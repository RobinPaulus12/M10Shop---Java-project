package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, String> {
    List<OrderLineEntity> findAllByOrder_Id(Integer orderId);
}
