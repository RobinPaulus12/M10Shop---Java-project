package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.ProductCategoryEntity;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, String> {
    ProductCategoryEntity findAllById(Integer id);
    //List<ProductCategoryEntity> findAllBy();
    ProductCategoryEntity findAllByName(String categoryName);

    @Query("SELECT pc FROM ProductCategoryEntity pc JOIN pc.translations t WHERE t.name = :name AND t.language.name = :language")
    ProductCategoryEntity findByTranslatedName(@Param("name") String name, @Param("language") String language);
}
