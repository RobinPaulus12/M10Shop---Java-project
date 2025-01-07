package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.ProductCategoryDataAccess;
import com.spring.henallux.javaProjectB3.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.javaProjectB3.dataAccess.dao.DiscountDataAccess;
import com.spring.henallux.javaProjectB3.dataAccess.dao.TranslationDAO;
import com.spring.henallux.javaProjectB3.model.Discount;
import com.spring.henallux.javaProjectB3.model.Product;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import com.spring.henallux.javaProjectB3.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/product")
public class ProductCategoryController extends SuperController {

    private final ProductCategoryDataAccess productCategoryDAO;
    private final ProductDataAccess productDAO;
    private final PromoService promoService;
    private final DiscountDataAccess discountDAO;

    @Autowired
    public ProductCategoryController(TranslationDAO translationDAO, ProductCategoryDataAccess productCategoryDAO, ProductDataAccess productDAO, PromoService promoService, DiscountDataAccess discountDAO) {
        super(translationDAO);
        this.productCategoryDAO = productCategoryDAO;
        this.productDAO = productDAO;
        this.promoService = promoService;
        this.discountDAO = discountDAO;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allProductsPage( Model model) {
        ArrayList<Product> products = productDAO.getAllProducts();
        Double price;
        HashMap<Integer, Double> realPrice = new HashMap<>();

        // Calculer les prix avec les promotions
        for (Product product : products) {
            Discount discount = discountDAO.findDiscountById(product.getDiscountId());
            if (discount != null) {
                price = promoService.promo(product.getPrice(), discount.getDiscountPercent());
                price = BigDecimal.valueOf(price).setScale(2, RoundingMode.DOWN).doubleValue();
            } else {
                price = product.getPrice();
            }
            realPrice.put(product.getId(), price);
        }
        model.addAttribute("realPrice", realPrice);
        model.addAttribute("product",products);
        model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());
        return "integrated:category";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String categoryPage(@PathVariable("id") Integer id, Model model, Locale locale) {
        Double price;

        // Rechercher la catégorie par ID
        ProductCategory categoryInfo = productCategoryDAO.findAllById(id);
        if (categoryInfo == null) {
            return "redirect:/error";
        }

        // Récupérer les produits liés à la catégorie
        ArrayList<Product> products = productDAO.findByCategoryId(categoryInfo.getId());
        HashMap<Integer, Double> realPrices = new HashMap<>();

        // Calculer les prix avec les promotions
        for (Product product : products) {
            Discount discount = discountDAO.findDiscountById(product.getDiscountId());
            if (discount != null) {
                price = promoService.promo(product.getPrice(), discount.getDiscountPercent());
                price = BigDecimal.valueOf(price).setScale(2, RoundingMode.DOWN).doubleValue();
            } else {
                price = product.getPrice();
            }
            realPrices.put(product.getId(), price);
        }

        model.addAttribute("realPrice", realPrices);
        model.addAttribute("productCategoryInfo", categoryInfo);
        model.addAttribute("product", products);
        model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());

        return "integrated:category";
    }
}
