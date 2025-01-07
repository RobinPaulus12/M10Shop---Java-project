package com.spring.henallux.javaProjectB3.model;

import jdk.jfr.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Translation {

    @NotNull
    @Min(value = 0)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    private ProductCategory category_id;

    @NotNull
    private String language;

    public Translation() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory_id() {
        return category_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(ProductCategory category_id) {
        this.category_id = category_id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
