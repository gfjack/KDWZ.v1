package com.company.management_system.converter;

import com.company.management_system.model.entity.OrderDetailsPo;
import com.company.management_system.model.entity.OrderPo;
import com.company.management_system.model.vo.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.company.management_system.utils.ErrorUtils.checkIfNull;
import static com.company.management_system.utils.ListUtils.ListToString;
import static com.company.management_system.utils.ListUtils.splitStringToList;

public class OrderConverter {

    public static OrderVo toOrderVo(OrderPo po) {
        OrderVo vo = new OrderVo();
        
        vo.setOrderNum(po.getOrderNum());
        vo.setDate(po.getDate());
        vo.setClientName(po.getClientName());
        vo.setSuppliers(splitStringToList(po.getSuppliers()));
        vo.setTransportations(splitStringToList(po.getTransportation()));
        vo.setPayDetails(po.getPayDetails());
        vo.setPayDate(po.getPayDate());
        vo.setIsDone(po.getIsDone());
        vo.setNotes(po.getNotes());

        return vo;
    }

    public static List<OrderVo> toOrderVos(List<OrderPo> pos) {
        List<OrderVo> res = new ArrayList<>();
        for (OrderPo po : pos) {
            OrderVo vo = toOrderVo(po);
            res.add(vo);
        }

        return res;
    }

    public static OrderPo toOrderPo(OrderVo vo, String orderNum) {
        OrderPo po = new OrderPo();

        po.setOrderNum(orderNum);
        po.setDate(vo.getDate());
        po.setClientName(vo.getClientName());
        po.setSuppliers(ListToString(vo.getSuppliers()));
        po.setTransportation(ListToString(vo.getTransportations()));
        po.setPayDetails(vo.getPayDetails());
        po.setPayDate(vo.getPayDate());
        po.setIsDone(vo.getIsDone());
        po.setNotes(vo.getNotes());

        return po;
    }

    public static OrderPo toOrderPo(OrderCreateVo vo, String orderNum) {
        OrderPo po = new OrderPo();

        po.setOrderNum(orderNum);
        po.setDate(vo.getDate());
        po.setClientName(vo.getClientName());
        po.setSuppliers(ListToString(vo.getSuppliers()));
        po.setTransportation(ListToString(vo.getTransportations()));
        po.setPayDetails(vo.getPayDetails());
        po.setPayDate(vo.getPayDate());
        po.setNotes(vo.getNotes());

        return po;
    }


    public static void updateOrder(OrderUpdateVo vo, OrderPo po) {
        po.setDate(checkIfNull(vo.getDate()) ? po.getDate() : vo.getDate());
        po.setClientName(checkIfNull(vo.getClientName()) ? po.getClientName() : vo.getClientName());
        po.setSuppliers(checkIfNull(vo.getSuppliers()) ? po.getSuppliers() : ListToString(vo.getSuppliers()));
        po.setTransportation(checkIfNull(vo.getTransportations()) ? po.getTransportation() : ListToString(vo.getTransportations()));
        po.setPayDetails(checkIfNull(vo.getPayDetails()) ? po.getPayDetails() : vo.getPayDetails());
        po.setPayDate(checkIfNull(vo.getPayDate()) ? po.getPayDate() : vo.getPayDate());
        po.setNotes(checkIfNull(vo.getNotes()) ? po.getNotes() : vo.getNotes());
    }

    public static OrderDetailsPo toOrderDetailPo(OrderDetailVo vo) {
        OrderDetailsPo po = new OrderDetailsPo();

        po.setTypeName(vo.getTypeName());
        po.setBrand(vo.getBrand());
        po.setMaterial(vo.getMaterial());
        po.setModel(vo.getModel());
        po.setPreNum(vo.getPreNum());
        po.setActualNum(vo.getActualNum());
        po.setPreWeight(vo.getPreWeight());
        po.setActualWeight(vo.getActualWeight());
        po.setClient(vo.getClient());
        po.setSalePrice(vo.getSalePrice());
        po.setSaleTotalPrice(vo.getActualWeight().multiply(vo.getSalePrice()));
        po.setSupplier(vo.getSupplier());
        po.setPurchasePrice(vo.getPurchasePrice());
        po.setPurchaseTotalPrice(vo.getActualWeight().multiply(vo.getPurchasePrice()));
        po.setTransport(vo.getTransport());
        po.setTransportPrice(vo.getTransportPrice());
        po.setTransportTotalPrice(vo.getActualWeight().multiply(vo.getTransportPrice()));
        po.setCarPlate(vo.getCarPlate());
        po.setNotes(vo.getNotes());
        po.setClientReceipt(vo.getClientReceipt());
        po.setSupplierReceipt(vo.getSupplierReceipt());
        po.setTransportReceipt(vo.getTransportReceipt());


        return po;
    }

    public static OrderDetailsPo toOrderDetailPo(OrderDetailCreateVo vo) {
        OrderDetailsPo po = new OrderDetailsPo();

        po.setDate(vo.getDate());
        po.setTypeName(vo.getTypeName());
        po.setBrand(vo.getBrand());
        po.setMaterial(vo.getMaterial());
        po.setModel(vo.getModel());
        po.setPreNum(vo.getPreNum());
        po.setActualNum(vo.getActualNum());
        po.setPreWeight(vo.getPreWeight());
        po.setActualWeight(vo.getActualWeight());
        po.setClient(vo.getClient());
        po.setSalePrice(vo.getSalePrice());
        po.setSaleTotalPrice(getTotalPrice(vo.getSalePrice(), vo.getActualWeight()));
        po.setSupplier(vo.getSupplier());
        po.setPurchasePrice(vo.getPurchasePrice());
        po.setPurchaseTotalPrice(getTotalPrice(vo.getPurchasePrice(), vo.getActualWeight()));
        po.setTransport(vo.getTransport());
        po.setTransportPrice(vo.getTransportPrice());
        po.setTransportTotalPrice(getTotalPrice(vo.getTransportPrice(), vo.getActualWeight()));
        po.setCarPlate(vo.getCarPlate());
        po.setNotes(vo.getNotes());
        po.setClientReceipt(vo.getClientReceipt());
        po.setSupplierReceipt(vo.getSupplierReceipt());
        po.setTransportReceipt(vo.getTransportReceipt());


        return po;
    }
    
    public static OrderDetailVo toOrderDetailsVo(OrderDetailsPo po) {
        OrderDetailVo vo = new OrderDetailVo();

        vo.setOrderDetailId(po.getOrderDetailId());
        vo.setTypeName(po.getTypeName());
        vo.setBrand(po.getBrand());
        vo.setMaterial(po.getMaterial());
        vo.setModel(po.getModel());
        vo.setPreNum(po.getPreNum());
        vo.setActualNum(po.getActualNum());
        vo.setPreWeight(po.getPreWeight());
        vo.setActualWeight(po.getActualWeight());
        vo.setClient(po.getClient());
        vo.setSalePrice(po.getSalePrice());
        vo.setSaleTotalPrice(getTotalPrice(po.getActualWeight(), po.getSalePrice()));
        vo.setSupplier(po.getSupplier());
        vo.setPurchasePrice(po.getPurchasePrice());
        vo.setPurchaseTotalPrice(getTotalPrice(po.getActualWeight(), po.getPurchasePrice()));
        vo.setTransport(po.getTransport());
        vo.setTransportPrice(po.getTransportPrice());
        vo.setTransportTotalPrice(getTotalPrice(po.getActualWeight(), po.getTransportPrice()));
        vo.setCarPlate(po.getCarPlate());
        vo.setNotes(po.getNotes());
        vo.setClientReceipt(po.getClientReceipt());
        vo.setSupplierReceipt(po.getSupplierReceipt());
        vo.setTransportReceipt(po.getTransportReceipt());

        return vo;
    }

    public static List<OrderDetailVo> toDetailsVos(List<OrderDetailsPo> pos) {
        List<OrderDetailVo> res = new ArrayList<>();
        for (OrderDetailsPo po : pos) {
            OrderDetailVo vo = toOrderDetailsVo(po);
            res.add(vo);
        }

        return res;
    }

    public static void updateOrderDetail(OrderDetailsPo po, OrderDetailUpdateVo vo) {
        po.setTypeName(checkIfNull(vo.getTypeName() )? po.getClient() : vo.getTypeName());
        po.setBrand(checkIfNull(vo.getBrand()) ? po.getBrand() : vo.getBrand());
        po.setMaterial(checkIfNull(vo.getMaterial()) ? po.getMaterial() : vo.getMaterial());
        po.setModel(checkIfNull(vo.getModel()) ? po.getModel() : vo.getModel());
        po.setPreNum(checkIfNull(vo.getPreNum()) ? po.getPreNum() : vo.getPreNum());
        po.setActualNum(checkIfNull(vo.getActualNum()) ? po.getActualNum() : vo.getActualNum());
        po.setPreWeight(checkIfNull(vo.getPreWeight()) ? po.getPreWeight() : vo.getPreWeight());
        po.setActualWeight(checkIfNull(vo.getActualWeight()) ? po.getActualWeight() : vo.getActualWeight());
        po.setClient(checkIfNull(vo.getClient()) ? po.getClient() : vo.getClient());
        po.setSalePrice(checkIfNull(vo.getSalePrice()) ? po.getSalePrice() : vo.getSalePrice());
        po.setSaleTotalPrice(getTotalPrice(vo.getActualWeight(), vo.getSalePrice()));
        po.setSupplier(checkIfNull(vo.getSupplier()) ? po.getSupplier() : vo.getSupplier());
        po.setPurchasePrice(checkIfNull(vo.getPurchasePrice()) ? po.getPurchasePrice() : vo.getPurchasePrice());
        po.setPurchaseTotalPrice(getTotalPrice(vo.getActualWeight(), vo.getPurchasePrice()));
        po.setTransport(checkIfNull(vo.getTransport()) ? po.getTransport() : vo.getTransport());
        po.setTransportPrice(checkIfNull(vo.getTransportPrice()) ? po.getTransportPrice() : vo.getTransportPrice());
        po.setTransportTotalPrice(getTotalPrice(vo.getActualWeight(), vo.getTransportTotalPrice()));
        po.setCarPlate(checkIfNull(vo.getCarPlate()) ? po.getCarPlate() : vo.getCarPlate());
        po.setNotes(checkIfNull(vo.getNotes()) ? po.getNotes() : vo.getNotes());
        po.setClientReceipt(checkIfNull(vo.getClientReceipt()) ? po.getClientReceipt() : vo.getClientReceipt());
        po.setSupplierReceipt(checkIfNull(vo.getSupplierReceipt()) ? po.getSupplierReceipt() : vo.getSupplierReceipt());
        po.setTransportReceipt(checkIfNull(vo.getTransportReceipt()) ? po.getTransportReceipt() : vo.getTransportReceipt());
    }

    public static BigDecimal getTotalPrice(BigDecimal singlePrice, BigDecimal qualities) {
        if (singlePrice == null || qualities == null) {
            return new BigDecimal(0);
        }
        return singlePrice.multiply(qualities);
    }

}
