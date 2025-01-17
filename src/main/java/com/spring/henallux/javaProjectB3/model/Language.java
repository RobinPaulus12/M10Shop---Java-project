package com.spring.henallux.javaProjectB3.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
