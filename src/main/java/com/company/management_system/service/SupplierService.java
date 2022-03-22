package com.company.management_system.service;

import com.company.management_system.model.vo.supplier.SupplierCreateVo;
import com.company.management_system.model.vo.supplier.SupplierUpdateVo;
import com.company.management_system.model.vo.supplier.SupplierVo;

import java.util.List;

public interface SupplierService {

    SupplierVo create(SupplierCreateVo supplierCreateVo);

    SupplierVo getByName(String supplierName);

    SupplierVo getById(Long supplierId);

    List<SupplierVo> getAll();

    SupplierVo update(SupplierUpdateVo supplierUpdateVo, Long supplierId);

    void deleteByName(String supplierName);

    void deleteById(Long supplierId);

}
