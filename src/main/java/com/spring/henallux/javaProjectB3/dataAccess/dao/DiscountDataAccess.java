package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.Discount;

public interface DiscountDataAccess {
    Discount findDiscountById(Integer id);
}
