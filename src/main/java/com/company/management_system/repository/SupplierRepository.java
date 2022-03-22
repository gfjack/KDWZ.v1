package com.company.management_system.repository;

import com.company.management_system.model.entity.SupplierPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierPo, Long> {

    boolean existsBySupplierName(String name);

    List<SupplierPo> findBySupplierName(String supplierName);

    void deleteBySupplierName(String supplierName);

    SupplierPo findBySupplierId(Long supplierId);

}
