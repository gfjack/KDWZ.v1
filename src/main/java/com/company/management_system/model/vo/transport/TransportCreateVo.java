package com.company.management_system.model.vo.transport;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("运输创建实体")
@Data
public class TransportCreateVo {

    @ApiModelProperty(value = "运输公司名称", required = true)
    @NotBlank
    protected String transportName;

    @ApiModelProperty("纳税人识别号")
    protected String taxNumber;

    @ApiModelProperty("银行开户行")
    protected String bank;

    @ApiModelProperty("银行行号")
    protected Long bankNum;

    @ApiModelProperty("银行账户号码")
    protected Long bankAccountNum;

    @ApiModelProperty("注册地址")
    protected String registerAddr;

    @ApiModelProperty("联系地址")
    protected String contactAddr;

    @ApiModelProperty(value = "联系人", required = true)
    @NotBlank
    protected String contact;

    @ApiModelProperty(value = "联系电话", required = true)
    @NotNull
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    protected String email;

}
