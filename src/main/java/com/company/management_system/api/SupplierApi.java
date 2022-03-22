package com.company.management_system.api;

import com.company.management_system.model.vo.supplier.SupplierCreateVo;
import com.company.management_system.model.vo.supplier.SupplierUpdateVo;
import com.company.management_system.model.vo.supplier.SupplierVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("供应商api")
public interface SupplierApi {

    @ApiOperation("创建供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    SupplierVo create(@ApiParam("创建供应商实体") @RequestBody SupplierCreateVo supplierCreateVo);

    @ApiOperation("根据供应商名称获取一个供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.GET)
    SupplierVo getByName(@ApiParam("供应商名称") @RequestParam("supplierName") String supplierName);

    @ApiOperation("根据供应商ID获取一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.GET)
    SupplierVo getById(@ApiParam("供应商名称") @PathVariable("supplier_id") Long supplierId);

    @ApiOperation("获取所有供应商")
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    List<SupplierVo> getAll();

    @ApiOperation("更新一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.PUT)
    SupplierVo update(@ApiParam("供应商更新实体") @RequestBody SupplierUpdateVo supplierUpdateVo,
                      @ApiParam("供应商id") @PathVariable("supplier_id") Long supplierId);

    @ApiOperation("根据供应商名称删除一个供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.DELETE)
    void deleteByName(@ApiParam("供应商名称") @RequestParam("supplierName") String supplierName);

    @ApiOperation("根据供应商ID删除一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.DELETE)
    void deleteById(@ApiParam("供应商名称") @PathVariable("supplier_id") Long supplierId);

    @ApiOperation("导出所有供应商")
    @RequestMapping(value = "/export_suppliers", method = RequestMethod.GET)
    void export(HttpServletResponse response);

}
