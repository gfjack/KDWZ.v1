package com.company.management_system.model.vo.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel("订单更新实体")
@Data
public class OrderUpdateVo {

    @ApiModelProperty("订单日期")
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
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
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    protected Date payDate;

    @ApiModelProperty("备注")
    protected String notes;

}
