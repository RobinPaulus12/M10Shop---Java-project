package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    List<OrderEntity> findAllByUser_Id(Integer userId);// Récupérer les commandes par utilisateur
    OrderEntity findById(Integer userId);
}
