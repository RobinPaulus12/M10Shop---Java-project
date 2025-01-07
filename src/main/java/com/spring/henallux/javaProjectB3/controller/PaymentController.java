package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"cart", Constants.CURRENT_USER})
@RequestMapping(value="/payment")
public class PaymentController extends SuperController {

    private OrderDataAccess orderDataAccess;
    private OrderLineDataAccess orderLineDataAccess;
    private UserDataAccess userDataAccess;
    private Order order;


    @Autowired
    public PaymentController(TranslationDAO translationDAO, OrderDAO orderDAO, OrderLineDAO orderLineDAO, UserDAO userDAO) {
        super(translationDAO);
        this.orderDataAccess = orderDAO;
        this.orderLineDataAccess = orderLineDAO;
        this.userDataAccess = userDAO;

    }

    @RequestMapping(method = RequestMethod.GET)
    public String payment(@ModelAttribute("cart") Cart cart, Model model, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();

        Order newOrder = new Order(currentUser,false);
        this.order = orderDataAccess.save(newOrder);
        order.getUser().setAccountNonExpired(true);
        order.getUser().setAccountNonLocked(true);
        order.getUser().setCredentialsNonExpired(true);
        order.getUser().setEnabled(true);

        for(OrderLine orderLine : cart.getCart().values()) {
            orderLine.setOrderId(order);
            orderLineDataAccess.save(orderLine);
        }

        currentUser.totalInvoices(cart.total());
        userDataAccess.save(currentUser);

        if(authentication.getPrincipal() == null) {
            return "integrated:login";
        }

        model.addAttribute("productCategory", super.getTranslationsByCurrentLocale());
        model.addAttribute("cart", cart);
        model.addAttribute("user", currentUser);
        return "redirect:/payment/summary"; // pour eviter que lorsqu'on raffraichi la page ou revient en arriere ca compte pour 2 ligne de commande

    }

    @RequestMapping(method = RequestMethod.GET, value ="/successful")
    public String paymentSuccessful(@ModelAttribute("cart") Cart cart) {
        order.setIsPaid(true);
        orderDataAccess.save(order);
        this.order = null;
        cart.getCart().clear();
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/canceled")
    public String paymentCanceled(@ModelAttribute("cart") Cart cart) {
        return "redirect:/cart";
    }


    // fonction pour eviter d'ajouter 2 ligne de commande pour un commande lors d'un raffrachisement de la page ou un retour en arriere
    @RequestMapping(method = RequestMethod.GET, value = "/summary")
    public String paymentSummary(Model model) {
        return "integrated:payment";
    }

}
