package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.ProductCategoryDAO;
import com.spring.henallux.javaProjectB3.dataAccess.dao.ProductCategoryDataAccess;
import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDAO;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/login")
public class LoginController extends SuperController {

    @Autowired
    public LoginController(TranslationDAO translationDAO) {
        super(translationDAO);
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        model.addAttribute("userLogin", new User());
        return "integrated:login";
    }
}
