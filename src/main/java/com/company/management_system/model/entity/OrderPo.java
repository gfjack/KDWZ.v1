package com.company.management_system.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_order")
@ApiModel(description = "业务表基类")
public class OrderPo extends BasePo {

    @ApiModelProperty("订单编号")
    @Column(name = "order_num")
    @Id
    protected String orderNum;

    @ApiModelProperty("订单日期")
    @Column(name = "date")
    protected Date date;

    @ApiModelProperty("客户名称")
    @Column(name = "client_name")
    protected String clientName;

    @ApiModelProperty("供应商名称, 多个")
    @Column(name = "suppliers")
    protected String suppliers;

    @ApiModelProperty("运输公司名称, 多个")
    @Column(name = "transportation")
    protected String transportation;

    @ApiModelProperty("付款细节")
    @Column(name = "pay_details")
    protected String payDetails;

    @ApiModelProperty("实付日期")
    @Column(name = "pay_date")
    protected Date payDate;

    @ApiModelProperty("是否完结, 当前订单所有详细订单发票情况完结后订单方可完结")
    @Column(name = "is_done")
    protected Boolean isDone = false;

    @ApiModelProperty("备注")
    @Column(name = "notes")
    protected String notes;

}
