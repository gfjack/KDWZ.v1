package com.company.management_system.model.vo.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel("创建订单细节实体")
@Data
public class OrderDetailCreateVo {

    @ApiModelProperty("订单日期")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    protected Date date;

    @ApiModelProperty("销售品种")
    protected String typeName;

    @ApiModelProperty("品牌厂家")
    protected String brand;

    @ApiModelProperty("材质")
    protected String material;

    @ApiModelProperty("规格型号")
    protected String model;

    @ApiModelProperty("预发件数")
    protected BigDecimal preNum;

    @ApiModelProperty("实发件数")
    protected BigDecimal actualNum;

    @ApiModelProperty("预发重量")
    protected BigDecimal preWeight;

    @ApiModelProperty("实发重量")
    protected BigDecimal actualWeight;

    @ApiModelProperty("客户")
    protected String client;

    @ApiModelProperty("销售单价")
    protected BigDecimal salePrice;

    @ApiModelProperty("供应商")
    protected String supplier;

    @ApiModelProperty("采购单价")
    protected BigDecimal purchasePrice;

    @ApiModelProperty("运输公司")
    protected String transport;

    @ApiModelProperty("运输单价")
    protected BigDecimal transportPrice;

    @ApiModelProperty("车牌号")
    protected String carPlate;

    @ApiModelProperty("备注")
    protected String notes;

    @ApiModelProperty("客户发票")
    protected Boolean clientReceipt;

    @ApiModelProperty("供应商发票")
    protected Boolean supplierReceipt;

    @ApiModelProperty("运输发票")
    protected Boolean transportReceipt;

}
