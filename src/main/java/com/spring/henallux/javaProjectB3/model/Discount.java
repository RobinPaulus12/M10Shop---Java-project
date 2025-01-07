package com.spring.henallux.javaProjectB3.model;

public class Discount {
    private Integer id;
    private String name;
    private String description;
    private Double discountPercent;
    private Boolean active;

    // Constructors
    public Discount() {
    }

    public Discount(Integer id, String name, String description, Double discountPercent, Boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discountPercent = discountPercent;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
