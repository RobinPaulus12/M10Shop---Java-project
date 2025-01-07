package com.spring.henallux.javaProjectB3.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation")
public class TranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private ProductCategoryEntity category;

    @JoinColumn(name = "language", referencedColumnName = "name")
    @ManyToOne
    private LanguageEntity language;

    public TranslationEntity() {}

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

    public ProductCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
