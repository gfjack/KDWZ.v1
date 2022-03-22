package com.company.management_system.model.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderFilterSearchVo {

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    @ApiModelProperty("订单开始时间")
    public Date startTime;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
    @ApiModelProperty("订单结束时间")
    public Date endTime;

    @ApiModelProperty("单位名称")
    public String companyName;

    @ApiModelProperty("单位性质, 1 = 客户, 2 = 供应商, 3 = 运输")
    public Integer companyType;

    @ApiModelProperty("是否完结")
    public Boolean isDone;

}
