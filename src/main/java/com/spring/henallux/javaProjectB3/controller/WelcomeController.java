package com.spring.henallux.javaProjectB3.controller;


import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.model.Discount;
import com.spring.henallux.javaProjectB3.model.Product;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import com.spring.henallux.javaProjectB3.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;



@Controller
@RequestMapping(value="/home")

public class WelcomeController extends  SuperController{
    private ProductCategoryDataAccess productCategoryDAO;
    private ProductDataAccess productDAO;
    private DiscountDAO discountDAO;
    private PromoService promoService;

    @Autowired
    public WelcomeController(TranslationDAO translationDAO, ProductCategoryDAO productCategoryDAO, ProductDAO productDAO, DiscountDAO discountDAO, PromoService promoService) {
        super(translationDAO);
        this.productCategoryDAO = productCategoryDAO;
        this.productDAO = productDAO;
        this.discountDAO= discountDAO;
        this.promoService = promoService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());

        // Récupération des produits de la catégorie "Maillots"
        ProductCategory jerseysCategory = productCategoryDAO.findAllByName("Maillots");
        ArrayList<Product> jerseys = new ArrayList<>();

        HashMap<Integer, Double> realPrices = new HashMap<>();
        if (jerseysCategory != null) {
            jerseys = productDAO.findByCategoryId(jerseysCategory.getId());

            // Calcul des prix avec réduction
            for (Product product : jerseys) {
                Discount discount = discountDAO.findDiscountById(product.getDiscountId());
                double finalPrice = (discount != null)
                        ? promoService.promo(product.getPrice(), discount.getDiscountPercent())
                        : product.getPrice();
                realPrices.put(product.getId(), BigDecimal.valueOf(finalPrice).setScale(2, RoundingMode.DOWN).doubleValue());
            }
        }

        model.addAttribute("maillots", jerseys);
        model.addAttribute("realPrice", realPrices);

        return "integrated:welcome";
    }


}

