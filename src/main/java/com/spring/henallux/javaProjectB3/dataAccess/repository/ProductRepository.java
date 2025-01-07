package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.ProductEntity;
import com.spring.henallux.javaProjectB3.dataAccess.entity.UserEntity;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId(Integer category);
    ProductEntity findAllById(Integer product);
}
