package com.company.management_system.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_supplier")
@ApiModel(description = "供应商表")
public class SupplierPo {

    @ApiModelProperty("供应商id")
    @Id
    @Column(name = "supplier_id")
    @GeneratedValue
    protected Long supplierId;

    @ApiModelProperty("供应商名称")
    @Column(name = "supplier_name")
    protected String supplierName;

    @ApiModelProperty("纳税人识别号")
    @Column(name = "tax_number")
    protected String taxNumber;

    @ApiModelProperty("银行开户行")
    @Column(name = "bank")
    protected String bank;

    @ApiModelProperty("银行行号")
    @Column(name = "bank_num")
    protected Long bankNum;

    @ApiModelProperty("银行账户号码")
    @Column(name = "bank_account_num")
    protected Long bankAccountNum;

    @ApiModelProperty("注册地址")
    @Column(name = "register_addr")
    protected String registerAddr;

    @ApiModelProperty("联系地址")
    @Column(name = "contact_addr")
    protected String contactAddr;

    @ApiModelProperty("联系人")
    @Column(name = "contact")
    protected String contact;

    @ApiModelProperty("联系电话")
    @Column(name = "contact_num")
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    @Column(name = "email")
    protected String email;

}
