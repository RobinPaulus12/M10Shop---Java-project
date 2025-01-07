package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDAO;
import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDataAccess;
import com.spring.henallux.javaProjectB3.model.Cart;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@SessionAttributes("cart")
public class SuperController {
    private TranslationDataAccess translationDataAccess;

    @Autowired
    public SuperController(TranslationDAO translationDAO) {
        this.translationDataAccess = translationDAO;
    }

    public ArrayList<ProductCategory> getTranslationsByCurrentLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        String language = locale.getLanguage();
        return translationDataAccess.getTranslationsByLanguage(language);
    }

    @ModelAttribute("cart")
    public Cart Cart() {
        return new Cart();
    }

}
