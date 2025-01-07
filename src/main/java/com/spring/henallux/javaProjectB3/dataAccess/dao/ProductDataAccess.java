package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts();
    Product getProductById(Integer productId);
    ArrayList<Product> findByCategoryId(Integer category);
    Product findAllById(Integer product);
}
