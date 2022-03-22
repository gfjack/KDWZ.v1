package com.company.management_system.model.vo.profit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("利润实体")
public class ProfitVo {

    @ApiModelProperty("订单编号")
    @Column(name = "order_num")
    protected String orderNum;

    @ApiModelProperty("订单日期")
    @Column(name = "date")
    protected Date date;

    @ApiModelProperty("客户")
    @Column(name = "client")
    protected String client;

    @ApiModelProperty("销售总价")
    @Column(name = "sale_price")
    protected BigDecimal salePrice;

    @ApiModelProperty("供应商, 多个")
    @Column(name = "suppliers")
    protected String suppliers;

    @ApiModelProperty("采购总价")
    @Column(name = "purchase_price")
    protected BigDecimal purchasePrice;

    @ApiModelProperty("运输公司, 多个")
    @Column(name = "transport")
    protected String transport;

    @ApiModelProperty("运输总价")
    @Column(name = "transportation_fee")
    protected BigDecimal transportationFee;

    @ApiModelProperty("其他费用")
    @Column(name = "other_fee")
    protected BigDecimal otherFee;

    @ApiModelProperty("利润")
    @Column(name = "profits")
    protected BigDecimal profits;

    @ApiModelProperty("是否完成")
    @Column(name = "is_done")
    protected Boolean isDone;

    @ApiModelProperty("备注")
    @Column(name = "notes")
    protected String notes;

}
