package com.company.management_system.model.vo.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("创建供应商实体")
@Data
public class SupplierCreateVo {

    @ApiModelProperty(value = "供应商名称", required = true)
    @NotBlank
    protected String supplierName;

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
    @NotBlank
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    protected String email;

}
