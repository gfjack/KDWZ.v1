package com.company.management_system.controller;

import com.company.management_system.api.SupplierApi;
import com.company.management_system.model.entity.ClientPo;
import com.company.management_system.model.entity.SupplierPo;
import com.company.management_system.model.vo.supplier.SupplierCreateVo;
import com.company.management_system.model.vo.supplier.SupplierUpdateVo;
import com.company.management_system.model.vo.supplier.SupplierVo;
import com.company.management_system.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.company.management_system.utils.ExcelUtils.export2File;

@Api("供应商api")
@RestController
@RequestMapping("/v1")
public  class SupplierController implements SupplierApi {

    @Resource
    private SupplierService supplierService;

    @ApiOperation("创建供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    public SupplierVo create(@ApiParam("创建供应商实体") @RequestBody SupplierCreateVo supplierCreateVo) {
        return supplierService.create(supplierCreateVo);
    }

    @ApiOperation("根据供应商名称获取一个供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.GET)
    public SupplierVo getByName(@ApiParam("供应商名称") @RequestParam("supplierName") String supplierName) {
        return supplierService.getByName(supplierName);
    }

    @ApiOperation("根据供应商ID获取一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.GET)
    public SupplierVo getById(@ApiParam("供应商名称") @PathVariable("supplier_id") Long supplierId) {
        return supplierService.getById(supplierId);
    }

    @ApiOperation("获取所有供应商")
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public List<SupplierVo> getAll() {
        return supplierService.getAll();
    }

    @ApiOperation("更新一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.PUT)
    public SupplierVo update(@ApiParam("供应商更新实体") @RequestBody SupplierUpdateVo supplierUpdateVo,
                      @ApiParam("供应商id") @NotNull @PathVariable("supplier_id") Long supplierId) {
        return supplierService.update(supplierUpdateVo, supplierId);
    }

    @ApiOperation("根据供应商名称删除一个供应商")
    @RequestMapping(value = "/supplier", method = RequestMethod.DELETE)
    public void deleteByName(@ApiParam("供应商名称") @RequestParam("supplierName") String supplierName) {
        supplierService.deleteByName(supplierName);
    }

    @ApiOperation("根据供应商ID删除一个供应商")
    @RequestMapping(value = "/supplier/{supplier_id}", method = RequestMethod.DELETE)
    public void deleteById(@ApiParam("供应商名称") @PathVariable("supplier_id") Long supplierId) {
        supplierService.deleteById(supplierId);
    }

    @ApiOperation("导出所有供应商")
    @RequestMapping(value = "/export_suppliers", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        export2File(response, "供应商表", "供应商信息", SupplierVo.class, supplierService.getAll());
    }

}
