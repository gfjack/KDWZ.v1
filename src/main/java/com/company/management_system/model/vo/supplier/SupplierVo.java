package com.company.management_system.model.vo.supplier;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@ApiModel("供应商实体")
@Data
public class SupplierVo {

    @ApiModelProperty("id")
    @ExcelIgnore
    protected Long id;

    @ApiModelProperty("供应商名称")
    @ExcelProperty(value = "供应商名称", index = 0)
    @ColumnWidth(20)
    protected String supplierName;

    @ApiModelProperty("纳税人识别号")
    @ExcelProperty(value = "客户税号", index = 1)
    @ColumnWidth(20)
    protected String taxNumber;

    @ApiModelProperty("银行开户行")
    @ExcelProperty(value = "银行", index = 2)
    @ColumnWidth(10)
    protected String bank;

    @ApiModelProperty("银行行号")
    @ExcelProperty(value = "银行行号", index = 3)
    @ColumnWidth(10)
    protected Long bankNum;

    @ApiModelProperty("银行账户号码")
    @ExcelProperty(value = "银行账号", index = 4)
    @ColumnWidth(20)
    protected Long bankAccountNum;

    @ApiModelProperty("注册地址")
    @ExcelProperty(value = "注册地址", index = 5)
    protected String registerAddr;

    @ApiModelProperty("联系地址")
    @ExcelProperty(value = "联系地址", index = 6)
    protected String contactAddr;

    @ApiModelProperty("联系人")
    @ExcelProperty(value = "联系人", index = 7)
    protected String contact;

    @ApiModelProperty("联系电话")
    @ExcelProperty(value = "联系电话", index = 8)
    @ColumnWidth(20)
    protected Long contactNum;

    @ApiModelProperty("邮箱")
    @ExcelProperty(value = "联系邮箱", index = 9)
    @ColumnWidth(20)
    protected String email;

}
