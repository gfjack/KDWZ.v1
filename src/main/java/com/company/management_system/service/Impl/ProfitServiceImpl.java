package com.company.management_system.service.Impl;

import com.company.management_system.exception.ProfitException;
import com.company.management_system.model.entity.OrderPo;
import com.company.management_system.model.entity.ProfitPo;
import com.company.management_system.model.vo.order.OrderDetailVo;
import com.company.management_system.model.vo.order.OrderVo;
import com.company.management_system.model.vo.profit.ProfitFilterVo;
import com.company.management_system.model.vo.profit.ProfitVo;
import com.company.management_system.repository.OrderRepository;
import com.company.management_system.repository.ProfitRepository;
import com.company.management_system.service.OrderService;
import com.company.management_system.service.ProfitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.management_system.converter.ProfitConverter.toProfitVo;

@Service
public class ProfitServiceImpl implements ProfitService {

    @Resource
    private ProfitRepository profitRepository;
    @Resource
    private OrderService orderService;
    @Resource
    private OrderRepository orderRepository;

    @Override
    public ProfitVo query(ProfitFilterVo profitFilterVo) {
        return null;
    }

    @Override
    public ProfitVo create(String orderNum) {
        ProfitPo profitPo = new ProfitPo();
        OrderPo order = orderRepository.findByOrderNum(orderNum);
        profitPo.setOrderNum(orderNum);
        profitPo.setClient(profitPo.getClient());
        profitPo.setDate(order.getDate());
        profitPo.setIsDone(order.getIsDone());
        profitPo.setSuppliers(order.getSuppliers());
        profitPo.setTransport(order.getTransportation());

        Map<String, BigDecimal> map = getTotalPrice(orderService.getOrderAllDetails(orderNum));
        profitPo.setSalePrice(map.get("saleTotalPrice"));
        profitPo.setPurchasePrice(map.get("purchaseTotalPrice"));
        profitPo.setTransportationFee(map.get("transportTotalPrice"));
        profitPo.setOtherFee(new BigDecimal(0));
        profitPo.setProfits(getProfits(profitPo.getSalePrice(), profitPo.getPurchasePrice(), profitPo.getTransportationFee(), profitPo.getOtherFee()));

        profitRepository.save(profitPo);
        return toProfitVo(profitPo);
    }

    private BigDecimal getProfits(BigDecimal salePrice, BigDecimal purchasePrice, BigDecimal transportPrice, BigDecimal others) {
        return salePrice.subtract(purchasePrice).subtract(transportPrice).subtract(others);
    }

    private Map<String, BigDecimal> getTotalPrice(List<OrderDetailVo> orderDetails) {
        Map<String, BigDecimal> map = new HashMap<>(3);
        BigDecimal saleTotalPrice = new BigDecimal(0);
        BigDecimal purchaseTotalPrice = new BigDecimal(0);
        BigDecimal transportTotalPrice = new BigDecimal(0);

        // 计算销售总额
        for (OrderDetailVo vo : orderDetails) {
            try {
                saleTotalPrice = saleTotalPrice.add(vo.getSaleTotalPrice());
            } catch (Exception e) {
                saleTotalPrice = new BigDecimal(0);
                break;
            }
        }

        // 计算采购金额
        for (OrderDetailVo vo : orderDetails) {
            try {
                purchaseTotalPrice = purchaseTotalPrice.add(vo.getPurchaseTotalPrice());
            } catch (Exception e) {
                purchaseTotalPrice = new BigDecimal(0);
                break;
            }
        }

        // 计算运输金额
        for (OrderDetailVo vo : orderDetails) {
            try {
                transportTotalPrice = transportTotalPrice.add(vo.getTransportTotalPrice());
            } catch (Exception e) {
                transportTotalPrice = new BigDecimal(0);
                break;
            }
        }

        map.put("saleTotalPrice", saleTotalPrice);
        map.put("purchaseTotalPrice", purchaseTotalPrice);
        map.put("transportTotalPrice", transportTotalPrice);

        return map;
    }

}
