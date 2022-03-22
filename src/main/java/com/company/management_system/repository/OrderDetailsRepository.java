package com.company.management_system.repository;

import com.company.management_system.model.entity.OrderDetailsPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderDetailsRepository extends JpaRepository<OrderDetailsPo, Long> {

    OrderDetailsPo findByOrderNumAndOrderDetailId(String orderNum, Long detailNum);

    List<OrderDetailsPo> findAllByOrderNum(String orderNum);

    void deleteAllByOrderNum(String orderNum);

}
