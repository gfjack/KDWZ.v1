package com.company.management_system.model.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel("订单实体")
@Data
public class OrderVo {

    @ApiModelProperty("订单编号")
    protected String orderNum;

    @ApiModelProperty("订单日期")
    protected Date date;

    @ApiModelProperty("客户名称")
    protected String clientName;

    @ApiModelProperty("供应商名称, 多个")
    protected List<String> suppliers;

    @ApiModelProperty("运输公司名称, 多个")
    protected List<String> transportations;

    @ApiModelProperty("付款细节")
    protected String payDetails;

    @ApiModelProperty("实付日期")
    protected Date payDate;

    @ApiModelProperty("是否完结, 当前订单所有详细订单发票情况完结后订单方可完结")
    protected Boolean isDone;

    @ApiModelProperty("备注")
    protected String notes;

}
