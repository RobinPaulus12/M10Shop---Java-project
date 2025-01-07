package com.spring.henallux.javaProjectB3.model;

public class OrderLine {
    private Integer id;
    private Order orderId; // On transporte juste l'ID de la commande
    private Product product; // On transporte juste l'ID du produit
    private String size;
    private Integer quantity;
    private Double price;

    public OrderLine(Integer id, Order orderId, Product product, String size, Integer quantity, Double price) {
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderLine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public Double getTotalPrice() {
        return this.price * this.quantity;
    }
}
