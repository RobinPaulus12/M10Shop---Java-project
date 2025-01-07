package com.spring.henallux.javaProjectB3.model;

import java.util.HashMap;

public class Cart {
    private HashMap<String,OrderLine> cart;

    public Cart() {
        cart = new HashMap<>();
    }


    public HashMap<String, OrderLine> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, OrderLine> cart) {
        this.cart = cart;
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderLine orderLine : cart.values()) {
            sum += orderLine.getPrice() * orderLine.getQuantity();
        }
        return sum;
    }

    public Integer totalQuantities() {
        Integer sum = 0;
        for(OrderLine orderLine : cart.values()) {
            sum+= orderLine.getQuantity();

        }
        return sum;
    }

    public void  addItem(OrderLine orderLine) {
        String key = orderLine.getProduct().getId() + "-" + orderLine.getSize();
        if(cart.containsKey(key)) {
            cart.get(key).addQuantity(orderLine.getQuantity());
        } else {
            cart.put(key,orderLine);
        }
    }
    public void modifyQuantity(String key, Integer quantity) {
        if (quantity == 0) {
            cart.remove(key);
        } else {
            cart.get(key).setQuantity(quantity);
        }
    }

    public void delete(String key) {
        cart.remove(key);
    }


}
