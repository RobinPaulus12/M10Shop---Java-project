package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/aboutUs")
public class AboutUsController extends SuperController{

    @Autowired
    public AboutUsController(TranslationDAO translationDAO) {
        super(translationDAO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String aboutUs(Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        return "integrated:aboutUs";
    }
}
