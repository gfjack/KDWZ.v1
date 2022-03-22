package com.company.management_system.model.vo.client;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("客户创建实体")
public class ClientCreateVo {

    @ApiModelProperty(value = "客户名称", required = true)
    @NotBlank(message = "客户名称不能为空")
    protected String clientName;

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
    @NotBlank(message = "联系人不能为空")
    protected String contact;

    @ApiModelProperty(value = "联系电话", required = true)
    @NotNull(message = "联系电话不能为空")
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    protected String email;

}
