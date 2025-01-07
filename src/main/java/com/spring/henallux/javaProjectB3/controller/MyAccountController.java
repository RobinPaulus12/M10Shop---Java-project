package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/myAccount")
@SessionAttributes({Constants.CURRENT_USER})
public class MyAccountController extends SuperController {

    @Autowired
    public MyAccountController(TranslationDAO translationDAO) {
        super(translationDAO);
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());
        return "integrated:myAccount";
    }

}

