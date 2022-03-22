package com.company.management_system.service.Impl;

import com.company.management_system.exception.CommonException;
import com.company.management_system.exception.OrderException;
import com.company.management_system.model.entity.OrderDetailsPo;
import com.company.management_system.model.entity.OrderPo;
import com.company.management_system.model.vo.order.*;
import com.company.management_system.repository.OrderDetailsRepository;
import com.company.management_system.repository.OrderRepository;
import com.company.management_system.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.company.management_system.constants.Constants.*;
import static com.company.management_system.constants.ErrorType.*;
import static com.company.management_system.converter.OrderConverter.*;
import static com.company.management_system.utils.CommonUtils.validateCompanyType;
import static com.company.management_system.utils.CommonUtils.validateTime;
import static com.company.management_system.utils.OrderUtils.generateOrderNum;
import static com.company.management_system.utils.SqlUtils.likeSearch;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;
    @Resource
    private OrderDetailsRepository orderDetailsRepository;

    private OrderPo getOrder(String orderNum) {
        OrderPo po = orderRepository.findByOrderNum(orderNum);
        if (null == po) {
            throw new OrderException(ORDER_NOT_EXISTS);
        }
        return po;
    }

    private OrderDetailsPo getOrderDetailPo(String orderNum, Long detailNum) {
        if (!StringUtils.hasLength(orderNum) || null == detailNum) {
            throw new OrderException(REQUEST_PARAMS_ERROR);
        }
        OrderDetailsPo po = orderDetailsRepository.findByOrderNumAndOrderDetailId(orderNum, detailNum);
        if (null == po) {
            throw new OrderException(ORDER_DETAIL_NOT_EXISTS);
        }
        return po;
    }

    @Override
    public OrderVo create(OrderCreateVo orderCreateVo) {
        orderRepository.findAllByDate(orderCreateVo.getDate());
        Integer ordersOfToday = orderRepository.countAllByDate(orderCreateVo.getDate());
        String orderNum = generateOrderNum(orderCreateVo.getDate(), ordersOfToday);

        OrderPo po = toOrderPo(orderCreateVo, orderNum);
        orderRepository.save(po);
        return toOrderVo(po);
    }

    @Override
    public OrderVo get(String orderNum) {
        return toOrderVo(getOrder(orderNum));
    }

    @Override
    public void delete(String orderNum) {
        OrderPo po = getOrder(orderNum);
        try {
            orderRepository.delete(po);
        } catch (Exception e) {
            throw new OrderException(e.getMessage());
        }

    }

    @Override
    public List<OrderVo> getAll() {
        return toOrderVos(orderRepository.findAll());
    }

    @Override
    public OrderVo update(OrderUpdateVo orderUpdateVo, String orderNum) {
        OrderPo po = getOrder(orderNum);
        updateOrder(orderUpdateVo, po);
        orderRepository.save(po);
        return toOrderVo(po);
    }


    @Override
    public List<OrderVo> search(String companyName, Integer companyType) {
        List<OrderPo> res = new ArrayList<>();
        switch (companyType) {
            case CLIENT:
                res = orderRepository.findAllByClientName(companyName);
                break;
            case SUPPLIER:
                res = orderRepository.findAllBySuppliersLike(companyName);
                break;
            case TRANSPORT:
                res = orderRepository.findAllByTransportationLike(companyName);
        }

        return toOrderVos(res);
    }

    @Override
    public List<OrderVo> filter(OrderFilterSearchVo orderFilterSearchVo) {
        List<OrderPo> res;
        Date startTime = orderFilterSearchVo.startTime;
        Date endTime = orderFilterSearchVo.endTime;
        String companyName = orderFilterSearchVo.companyName;
        Integer companyType = orderFilterSearchVo.companyType;
        Boolean isDone = orderFilterSearchVo.isDone;
        validateTime(startTime, endTime);
        validateCompanyType(companyName, companyType);
        if (null != companyType) {
            switch (companyType) {
                case CLIENT:
                    res = orderRepository.findAllByDateBetweenAndCompanyNameAndIsDone(startTime, endTime, companyName, null, null, isDone);
                    break;
                case SUPPLIER:
                    res = orderRepository.findAllByDateBetweenAndCompanyNameAndIsDone(startTime, endTime, null, likeSearch(companyName), null, isDone);
                    break;
                case TRANSPORT:
                    res = orderRepository.findAllByDateBetweenAndCompanyNameAndIsDone(startTime, endTime, null, null, likeSearch(companyName), isDone);
                    break;
                default:
                    throw new CommonException("请输入正确公司类型");
            }
        } else {
            res = orderRepository.findAllByDateBetweenAndCompanyNameAndIsDone(startTime, endTime, null, null, null, isDone);
        }

        return toOrderVos(res);
    }

    @Override
    public List<OrderVo> query(Integer current, Integer limit) {
        List<OrderPo> res = orderRepository.query(current - 1, limit);

        return toOrderVos(res);
    }

    @Override
    public List<OrderDetailVo> create(List<OrderDetailCreateVo> details, String orderNum) {
        getOrder(orderNum);
        List<OrderDetailsPo> res = new ArrayList<>();
        for (OrderDetailCreateVo vo : details) {
            try {
                OrderDetailsPo po = toOrderDetailPo(vo);
                po.setOrderNum(orderNum);
                orderDetailsRepository.save(po);
                res.add(po);
            } catch (Exception e) {
                throw new OrderException(e.getMessage());
            }
        }

        return toDetailsVos(res);
    }

    @Override
    public List<OrderDetailVo> getOrderAllDetails(String orderNum) {
        return toDetailsVos(orderDetailsRepository.findAllByOrderNum(orderNum));
    }

    @Override
    public OrderDetailVo updateOneDetails(OrderDetailUpdateVo orderDetail, String orderNum, Long orderDetailNum) {
        OrderDetailsPo po = getOrderDetailPo(orderNum, orderDetailNum);
        updateOrderDetail(po, orderDetail);
        orderDetailsRepository.save(po);
        return toOrderDetailsVo(po);
    }

    @Override
    public void updateDetailTotalPrice(String orderNum) {
        List<OrderDetailsPo> details = orderDetailsRepository.findAllByOrderNum(orderNum);
        for (OrderDetailsPo detail : details) {
            BigDecimal actualWeight = detail.getActualWeight();
            detail.setSaleTotalPrice(getTotalPrice(detail.getSalePrice(), actualWeight));
            detail.setPurchaseTotalPrice(getTotalPrice(detail.getPurchasePrice(), actualWeight));
            detail.setTransportTotalPrice(getTotalPrice(detail.getTransportPrice(), actualWeight));
            orderDetailsRepository.save(detail);
        }
    }

    @Override
    public void deleteOneDetail(String orderNum, Long orderDetailNum) {
        OrderDetailsPo po = getOrderDetailPo(orderNum, orderDetailNum);
        try {
            orderDetailsRepository.delete(po);
        } catch (Exception e) {
            throw new OrderException(e.getMessage());
        }
    }

    @Override
    public void deleteAllDetail(String orderNum) {
        try {
            orderDetailsRepository.deleteAllByOrderNum(orderNum);
        } catch (Exception e) {
            throw new OrderException(e.getMessage());
        }
    }
}
