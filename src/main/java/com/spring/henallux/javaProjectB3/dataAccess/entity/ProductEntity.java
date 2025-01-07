package com.spring.henallux.javaProjectB3.dataAccess.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private DiscountEntity discount;

    @Column(name = "picture_link")
    private String pictureLink;

    @OneToMany(mappedBy="product")
    private Collection<OrderLineEntity> orderLines;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEntity category) {
        this.category = category;
    }

    public DiscountEntity getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountEntity discount) {
        this.discount = discount;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
