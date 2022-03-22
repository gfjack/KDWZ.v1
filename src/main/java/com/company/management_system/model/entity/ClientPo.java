package com.company.management_system.model.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_client")
@ApiModel(description = "客户表")
public class ClientPo {

    @ApiModelProperty("客户id")
    @Id
    @Column(name = "client_id")
    @GeneratedValue
    @ExcelIgnore
    protected Long clientId;

    @ApiModelProperty("客户名称")
    @Column(name = "client_name")
    @ExcelProperty(value = "客户名称", index = 0)
    @ColumnWidth(20)
    protected String clientName;

    @ApiModelProperty("纳税人识别号")
    @Column(name = "tax_number")
    @ExcelProperty(value = "客户税号", index = 1)
    @ColumnWidth(20)
    protected String taxNumber;

    @ApiModelProperty("银行开户行")
    @Column(name = "bank")
    @ExcelProperty(value = "银行", index = 2)
    @ColumnWidth(10)
    protected String bank;

    @ApiModelProperty("银行行号")
    @Column(name = "bank_num")
    @ExcelProperty(value = "银行行号", index = 3)
    @ColumnWidth(10)
    protected Long banNum;

    @ApiModelProperty("银行账户号码")
    @Column(name = "bank_account_num")
    @ExcelProperty(value = "银行账号", index = 4)
    @ColumnWidth(20)
    protected Long bankAccountNum;

    @ApiModelProperty("注册地址")
    @Column(name = "register_addr")
    @ExcelProperty(value = "注册地址", index = 5)
    protected String registerAddr;

    @ApiModelProperty("联系地址")
    @Column(name = "contact_addr")
    @ExcelProperty(value = "联系地址", index = 6)
    protected String contactAddr;

    @ApiModelProperty("联系人")
    @Column(name = "contact")
    @ExcelProperty(value = "联系人", index = 7)
    protected String contact;

    @ApiModelProperty("联系电话")
    @Column(name = "contact_num")
    @ExcelProperty(value = "联系电话", index = 8)
    @ColumnWidth(20)
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    @Column(name = "email")
    @ExcelProperty(value = "联系邮箱", index = 9)
    @ColumnWidth(20)
    protected String email;

}
