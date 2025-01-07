package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.model.Order;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/myAccount/myOrders/details")
@SessionAttributes({Constants.CURRENT_USER})
public class OrderDetailsController extends SuperController {

    private OrderDataAccess orderDAO;
    private UserDataAccess userDAO;

    @Autowired
    public OrderDetailsController(TranslationDAO translationDAO, OrderDAO orderDAO, UserDAO userDAO) {
        super(translationDAO);
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User getCurrentUser(Authentication authentication) {
        // Récupère l'utilisateur connecté
        String username = authentication.getName();
        return userDAO.findByUsername(username);
    }

    @GetMapping("/{orderId}")
    public String getOrderDetails(
            @PathVariable("orderId") Integer orderId,
            @ModelAttribute(Constants.CURRENT_USER) User currentUser,
            Model model) {

        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());

        // Vérification si l'utilisateur est connecté
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Récupération des détails de la commande par son ID
        Order order = orderDAO.getOrderById(orderId);

        // Vérification si la commande appartient à l'utilisateur
        if (order == null || !order.getUser().getId().equals(currentUser.getId())) {
            return "redirect:/myAccount/myOrders"; // Redirection si l'accès est non autorisé
        }

        // Ajouter les détails de la commande au modèle
        model.addAttribute("order", order);

        return "integrated:orderDetails"; // Correspond à la JSP des détails de la commande
    }
}
