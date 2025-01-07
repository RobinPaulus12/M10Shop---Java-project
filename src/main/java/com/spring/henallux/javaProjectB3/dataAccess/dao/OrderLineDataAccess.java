package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.OrderLine;

import java.util.List;

public interface OrderLineDataAccess {
    List<OrderLine> getOrderLinesByOrderId(Integer orderId);
    OrderLine save(OrderLine orderLine);
}
