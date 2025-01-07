package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.model.Order;
import com.spring.henallux.javaProjectB3.model.OrderLine;
import com.spring.henallux.javaProjectB3.model.User;
import com.spring.henallux.javaProjectB3.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/myAccount/myOrders")
@SessionAttributes({Constants.CURRENT_USER})
public class UserOrdersController extends SuperController{

    private OrderDataAccess orderDAO;
    private UserDataAccess userDAO;
    private OrderLineDataAccess orderLineDAO;

    @Autowired
    public UserOrdersController(TranslationDAO translationDAO, OrderDAO orderDAO, UserDAO userDAO, OrderLineDAO orderLineDAO) {
        super(translationDAO);
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
        this.orderLineDAO = orderLineDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User getCurrentUser(Authentication authentication) {
        // Récupérer l'utilisateur authentifié
        String username = authentication.getName();
        return userDAO.findByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayOrders(@ModelAttribute(Constants.CURRENT_USER) User user, Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        // Vérifier que l'utilisateur existe
        if (user == null) {
            return "redirect:/login"; // Redirection vers la page de connexion si l'utilisateur n'est pas connecté
        }

        // Récupérer les commandes pour cet utilisateur
        ArrayList<Order> orders = orderDAO.getOrdersByUsername_id(user.getId());


        for (Order order : orders) {
            double totalPrice = 0;
            List<OrderLine> orderLines = orderLineDAO.getOrderLinesByOrderId(order.getId());
            for(OrderLine orderLine : orderLines) {
                totalPrice += orderLine.getTotalPrice(); // Utilisez getTotalPrice() pour le calcul
            }
            order.setTotalPrice(totalPrice);
        }

        // Ajouter les commandes au modèle
        model.addAttribute("orders", orders);

        return "integrated:userOrders"; // Correspond à votre page JSP
    }
}
