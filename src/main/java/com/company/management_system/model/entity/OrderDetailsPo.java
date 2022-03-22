package com.company.management_system.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "t_order_details")
@ApiModel(description = "订单详细信息PO基类")
public class OrderDetailsPo {

    @ApiModelProperty("ID")
    @Column(name = "order_detail_id")
    @Id
    @GeneratedValue
    protected Long orderDetailId;

    @ApiModelProperty("订单编号")
    @Column(name = "order_num")
    protected String orderNum;

    @ApiModelProperty("订单日期")
    @Column(name = "date")
    protected Date date;

    @ApiModelProperty("销售品种")
    @Column(name = "type_name")
    protected String typeName;

    @ApiModelProperty("品牌厂家")
    @Column(name = "brand")
    protected String brand;

    @ApiModelProperty("材质")
    @Column(name = "material")
    protected String material;

    @ApiModelProperty("规格型号")
    @Column(name = "model")
    protected String model;

    @ApiModelProperty("预发件数")
    @Column(name = "pre_num", precision = 15, scale = 4)
    protected BigDecimal preNum;

    @ApiModelProperty("实发件数")
    @Column(name = "actual_num", precision = 15, scale = 4)
    protected BigDecimal actualNum;

    @ApiModelProperty("预发重量")
    @Column(name = "pre_weight", precision = 15, scale = 4)
    protected BigDecimal preWeight;

    @ApiModelProperty("实发重量")
    @Column(name = "actual_weight", precision = 15, scale = 4)
    protected BigDecimal actualWeight;

    @ApiModelProperty("客户")
    @Column(name = "client")
    protected String client;

    @ApiModelProperty("销售单价")
    @Column(name = "sale_price", precision = 15, scale = 4)
    protected BigDecimal salePrice;

    @ApiModelProperty("销售总价")
    @Column(name = "sale_total_price", precision = 15, scale = 4)
    protected BigDecimal saleTotalPrice;

    @ApiModelProperty("供应商")
    @Column(name = "supplier")
    protected String supplier;

    @ApiModelProperty("采购单价")
    @Column(name = "purchase_price", precision = 15, scale = 4)
    protected BigDecimal purchasePrice;

    @ApiModelProperty("采购总价")
    @Column(name = "purchase_total_price", precision = 15, scale = 4)
    protected BigDecimal purchaseTotalPrice;

    @ApiModelProperty("运输公司")
    @Column(name = "transport")
    protected String transport;

    @ApiModelProperty("运输单价")
    @Column(name = "transport_price", precision = 15, scale = 4)
    protected BigDecimal transportPrice;

    @ApiModelProperty("运输总价")
    @Column(name = "transport_total_price", precision = 15, scale = 4)
    protected BigDecimal transportTotalPrice;

    @ApiModelProperty("车牌号")
    @Column(name = "car_plate")
    protected String carPlate;

    @ApiModelProperty("备注")
    @Column(name = "notes")
    protected String notes;

    @ApiModelProperty("客户发票")
    @Column(name = "client_receipt")
    protected Boolean clientReceipt;

    @ApiModelProperty("供应商发票")
    @Column(name = "supplier_receipt")
    protected Boolean supplierReceipt;

    @ApiModelProperty("运输发票")
    @Column(name = "transport_receipt")
    protected Boolean transportReceipt;

}
