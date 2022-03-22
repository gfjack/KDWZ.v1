package com.company.management_system.service.Impl;

import com.company.management_system.exception.SupplierException;
import com.company.management_system.model.entity.SupplierPo;
import com.company.management_system.model.vo.supplier.SupplierCreateVo;
import com.company.management_system.model.vo.supplier.SupplierUpdateVo;
import com.company.management_system.model.vo.supplier.SupplierVo;
import com.company.management_system.repository.SupplierRepository;
import com.company.management_system.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.company.management_system.constants.ErrorType.SUPPLIER_ALREADY_EXISTS;
import static com.company.management_system.constants.ErrorType.SUPPLIER_NOT_EXISTS;
import static com.company.management_system.converter.SupplierConverter.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierRepository supplierRepository;

    public SupplierPo getOne(String supplierName) {
        try {
            List<SupplierPo> res = supplierRepository.findBySupplierName(supplierName);
            return res.get(0);
        } catch (Exception e) {
            throw new SupplierException(SUPPLIER_NOT_EXISTS);
        }
    }

    public SupplierPo getOne(Long supplierId) {
        SupplierPo po = supplierRepository.findBySupplierId(supplierId);
        if (null == po) {
            throw new SupplierException(SUPPLIER_NOT_EXISTS);
        }
        return po;
    }

    @Override
    public SupplierVo create(SupplierCreateVo supplierCreateVo) {
        if (supplierRepository.existsBySupplierName(supplierCreateVo.getSupplierName())) {
            throw new SupplierException(SUPPLIER_ALREADY_EXISTS);
        }
        SupplierPo supplierPo = toSupplierPo(supplierCreateVo);
        supplierRepository.save(supplierPo);
        return toSupplierVo(supplierPo);
    }

    @Override
    public SupplierVo getByName(String supplierName) {
        return toSupplierVo(getOne(supplierName));
    }

    @Override
    public SupplierVo getById(Long supplierId) {
        return toSupplierVo(getOne(supplierId));
    }

    @Override
    public List<SupplierVo> getAll() {
        return toSupplierVos(supplierRepository.findAll());
    }

    @Override
    public SupplierVo update(SupplierUpdateVo supplierUpdateVo, Long supplierId) {
        SupplierPo po = getOne(supplierId);
        updateSupplier(supplierUpdateVo, po);
        supplierRepository.save(po);
        return toSupplierVo(po);
    }

    @Override
    public void deleteByName(String supplierName) {
        SupplierPo po = getOne(supplierName);
        try {
            supplierRepository.delete(po);
        } catch (Exception e) {
            throw new SupplierException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long supplierId) {
        SupplierPo po = getOne(supplierId);
        try {
            supplierRepository.delete(po);
        } catch (Exception e) {
            throw new SupplierException(e.getMessage());
        }
    }
}
