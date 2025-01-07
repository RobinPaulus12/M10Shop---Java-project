package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.model.*;
import com.spring.henallux.javaProjectB3.service.PromoService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({"cart", Constants.CURRENT_USER})
public class CartController extends SuperController {

    private PromoService promoService;
    private DiscountDAO discountDAO;

    public CartController(TranslationDAO translationDAO, PromoService promoService, DiscountDAO discountDao) {
        super(translationDAO);
        this.promoService = promoService;
        this.discountDAO = discountDao;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute("cart")  Cart cart, Authentication authentication) {
        HashMap<String, Double> realPrices = new HashMap<>();
        double total = 0.0;

        // on calcule la promo pour afficher dans le panier

        for (String key : cart.getCart().keySet()) {
            OrderLine orderLine = cart.getCart().get(key);
            Product product = orderLine.getProduct();
            Discount discount = product.getDiscountId() != null ? discountDAO.findDiscountById(product.getDiscountId()) : null;

            double realPrice = product.getPrice();
            if (discount != null) {
                realPrice = promoService.promo(realPrice, discount.getDiscountPercent());
            }
            realPrices.put(key, BigDecimal.valueOf(realPrice).setScale(2, RoundingMode.DOWN).doubleValue());

            total += realPrice * orderLine.getQuantity();
        }
        total = BigDecimal.valueOf(total).setScale(2, RoundingMode.DOWN).doubleValue();
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        model.addAttribute("orderLine", new OrderLine());
        model.addAttribute("cart",cart);
        model.addAttribute("realPrices", realPrices);
        model.addAttribute("total", total); // afficher le bon total apres reduction
        model.addAttribute("user", authentication != null ? (User) authentication.getPrincipal() : null);
        return "integrated:cart";
    }



    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String modifyQuantity(@ModelAttribute Cart cart, @RequestParam String key, @Valid @ModelAttribute(value = "lineOrder") OrderLine OrderLine) {
        cart.modifyQuantity(key, OrderLine.getQuantity());
        return "redirect:/cart";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public String delete(@ModelAttribute Cart cart, @RequestParam String key, @Valid @ModelAttribute(value = "lineOrder") OrderLine OrderLine) {
        cart.delete(key);
        return "redirect:/cart";
    }
}
