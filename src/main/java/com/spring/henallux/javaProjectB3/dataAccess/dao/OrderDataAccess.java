package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.Order;

import java.util.ArrayList;

public interface OrderDataAccess {
    Order save(Order order);
    ArrayList<Order> getOrdersByUsername_id(Integer userId);
    Order getOrderById(Integer orderId);
}
