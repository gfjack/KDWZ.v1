package com.company.management_system.model.vo.profit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("利润分页搜索实体")
public class ProfitFilterVo {

    @ApiModelProperty("日期")
    protected Date date;

    @ApiModelProperty("客户名称")
    protected String clientName;

    @ApiModelProperty("当前页")
    protected Integer current;

    @ApiModelProperty("limit")
    protected Integer limit;


}
