package com.company.management_system.repository;

import com.company.management_system.model.entity.TransportationPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRepository extends JpaRepository<TransportationPo, Long> {

    boolean existsByTransportName(String name);

    List<TransportationPo> findByTransportName(String transport);

    TransportationPo findByTransportId(Long id);

}
