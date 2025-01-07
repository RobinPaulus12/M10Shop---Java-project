package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.ProductCategory;

import java.util.ArrayList;

public interface TranslationDataAccess {
    ArrayList<ProductCategory> getTranslationsByLanguage(String language);
}
