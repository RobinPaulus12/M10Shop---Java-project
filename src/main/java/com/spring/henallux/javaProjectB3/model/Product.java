package com.spring.henallux.javaProjectB3.model;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private String color;
    private Double price;
    private Integer categoryId;
    private Integer discountId;
    private String pictureLink;

    public Product() {
    }

    public Product(Integer id, String name, String description, String color, Double price, Integer categoryId, Integer discountId, String pictureLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.price = price;
        this.categoryId = categoryId;
        this.discountId = discountId;
        this.pictureLink = pictureLink;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
