package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<DiscountEntity, String> {
    DiscountEntity findDiscountById(Integer discount);
}
