package com.company.management_system.repository;

import com.company.management_system.model.entity.OrderPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface OrderRepository extends JpaRepository<OrderPo, String> {

    Integer countAllByDate(Date date);

    List<OrderPo> findAllByDate(Date date);

    OrderPo findByOrderNum(String orderNum);

    List<OrderPo> findAllByClientName(String clientName);

    @Query(value = "SELECT * FROM t_order where suppliers LIKE %?1%", nativeQuery = true)
    List<OrderPo> findAllBySuppliersLike(String supplier);

    @Query(value = "SELECT * FROM t_order where transportation LIKE %?1%", nativeQuery = true)
    List<OrderPo> findAllByTransportationLike(String transport);

    @Query(value = "SELECT * FROM t_order where 1=1 AND IF(?1 IS NULL AND ?2 IS NULL, 1=1, t_order.date BETWEEN ?1 AND ?2)"+
                    " AND IF(?3 IS NULL, 1=1, client_name=?3) AND IF(?4 IS NULL, 1=1, suppliers LIKE ?4) AND IF(?5 IS NULL, 1=1, transportation LIKE ?5)" +
                    " AND IF(?4 IS NULL, 1=1, is_done=?4)", nativeQuery = true)
    List<OrderPo> findAllByDateBetweenAndCompanyNameAndIsDone(Date startTime, Date endTime, String clientName, String supplierName, String transportation, Boolean isDone);

    @Query(value = "SELECT * FROM t_order where 1=1" +
            " AND IF(?1 IS NULL, 1=1, client_name=?1)" +
            " AND IF(?2 IS NULL, 1=1, is_done=?2)", nativeQuery = true)
    List<OrderPo> findAllByClientNameAndIsDone(String clientName, Boolean isDone);

    @Query(value = "SELECT * FROM t_order LIMIT ?1, ?2", nativeQuery = true)
    List<OrderPo> query(Integer current, Integer limit);

}
