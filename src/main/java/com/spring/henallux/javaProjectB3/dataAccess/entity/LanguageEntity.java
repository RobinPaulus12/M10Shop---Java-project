package com.spring.henallux.javaProjectB3.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="language")
public class LanguageEntity {

    @Id
    @Column(name="name")
    private String name;

    public LanguageEntity() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
