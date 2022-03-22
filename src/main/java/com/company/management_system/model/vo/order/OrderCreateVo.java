package com.company.management_system.model.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("订单创建实体")
public class OrderCreateVo {

    @ApiModelProperty(value = "客户名称", required = true)
    @NotBlank(message = "请输入客户名称")
    protected String clientName;

    @ApiModelProperty(value = "订单日期", required = true)
    @NotNull
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    protected Date date;

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
