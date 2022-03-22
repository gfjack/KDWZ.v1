package com.company.management_system.repository;

import com.company.management_system.model.entity.ClientPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientPo, Long> {
    List<ClientPo> findByClientName(String clientName);

    boolean existsByClientName(String clientName);

    ClientPo findByClientId(Long clientId);


    @Query(value = "SELECT * FROM t_client", nativeQuery = true)
    List<List<String>> findAllObject();
}
