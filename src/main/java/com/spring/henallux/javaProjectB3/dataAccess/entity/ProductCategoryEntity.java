package com.spring.henallux.javaProjectB3.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="product_category")
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", columnDefinition = "TEXT") // Pour gérer le type TEXT
    private String description;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<ProductEntity> products;

    @OneToMany(mappedBy = "category")
    private Collection<TranslationEntity> translations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
