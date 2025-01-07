package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.ProductCategory;

import java.util.ArrayList;

public interface ProductCategoryDataAccess {
    ProductCategory findAllById(Integer id);
    ArrayList<ProductCategory> findAll();
    ProductCategory findAllByName(String categoryName);
    ProductCategory findByTranslatedName(String name,String language);
}
