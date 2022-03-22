package com.company.management_system.service;

import com.company.management_system.model.vo.order.*;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderVo create(OrderCreateVo orderVo);

    OrderVo get(String orderNum);

    void delete(String orderNum);

    List<OrderVo> getAll();

    OrderVo update(OrderUpdateVo orderUpdateVo, String orderNum);

    List<OrderVo> search(String companyName, Integer companyType);

    List<OrderVo> filter(OrderFilterSearchVo orderFilterSearchVo);

    List<OrderVo> query(Integer current, Integer limit);

    List<OrderDetailVo> create(List<OrderDetailCreateVo> details, String orderNum);

    List<OrderDetailVo> getOrderAllDetails(String number);

    OrderDetailVo updateOneDetails(OrderDetailUpdateVo orderDetail, String orderNum, Long orderDetailNum);

    void updateDetailTotalPrice(String orderNum);

    void deleteOneDetail(String orderNum, Long orderDetailNum);

    void deleteAllDetail(String orderNum);

}
