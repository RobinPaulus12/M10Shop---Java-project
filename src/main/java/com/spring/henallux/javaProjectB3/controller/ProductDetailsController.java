package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.model.*;
import com.spring.henallux.javaProjectB3.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;


@Controller
@RequestMapping(value="/products")
@SessionAttributes("cart")
public class ProductDetailsController extends SuperController {

    private ProductCategoryDataAccess productCategoryDAO;
    private Product product;
    private ProductDataAccess productDAO;
    private PromoService promoService;
    private DiscountDataAccess discountDAO;
    private MessageSource messageSource;

    @Autowired
    public ProductDetailsController(TranslationDAO translationDAO, ProductCategoryDAO productCategoryDAO, ProductDAO productDAO, DiscountDAO discountDAO, PromoService promoService, MessageSource messageSource) {
        super(translationDAO);
        this.productCategoryDAO = productCategoryDAO;
        this.productDAO = productDAO;
        this.discountDAO = discountDAO;
        this.promoService = promoService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String productDetails(@PathVariable("id") Integer id, Model model) {
        Double price;
        product = productDAO.findAllById(id);
        Discount discount = discountDAO.findDiscountById(product.getDiscountId()); // renvoie la promo en fonction de l'id de la promo dans product
        ProductCategory productCategoryInfos = productCategoryDAO.findAllById(product.getCategoryId()); // recupere les infos de la categorie en fonction de l'id de categorie du produit

        if(discount != null) {
            price = promoService.promo(product.getPrice(), discount.getDiscountPercent());
            price = BigDecimal.valueOf(price).setScale(2, RoundingMode.DOWN).doubleValue();// service pour calculer la promo
        } else {
            price = product.getPrice();
        }


        model.addAttribute("realPrice",price);
        model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());
        model.addAttribute("productDetails",product);
        model.addAttribute("productCategoryInfos",productCategoryInfos);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:productDetails";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String sendQuantity(Model model, @ModelAttribute("cart")  Cart cart, @Valid @ModelAttribute(value = "orderLine") OrderLine orderLine, @RequestParam("price") Double price, Locale locale, RedirectAttributes redirectAttributes) {

        if ("DEFAULT".equals(orderLine.getSize()) || orderLine.getSize().isEmpty()) {
            model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());
            String errorMessage = messageSource.getMessage("errorMessageAboutSize", null, locale);
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage); // transmettre le message d'erreur lors de la redirection
            return "redirect:/products/" + product.getId(); // Retourne à la page de détails produit
        }

        orderLine.setProduct(product);
        orderLine.setPrice(price);
        cart.addItem(orderLine);
        return "redirect:/cart";
    }

}
