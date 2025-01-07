package com.spring.henallux.javaProjectB3.model;

import java.util.List;

public class Order {
    private Integer id;

    private User user;

    private Boolean isPaid;

    private List<OrderLine> orderLines; // Liste des lignes de commande
    private Double totalPrice;

    public Order(User user, Boolean isPaid) {
        this.user = user;
        this.isPaid = isPaid;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
