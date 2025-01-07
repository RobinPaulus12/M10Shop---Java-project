package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value="/inscription")
public class InscriptionController extends SuperController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    private UserDataAccess userDAO;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;


    @Autowired
    public InscriptionController(TranslationDAO translationDAO, UserDAO userDAO, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        super(translationDAO);
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        model.addAttribute("userForm", new User());
        return "integrated:userInscription";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @RequestMapping (value ="/send", method=RequestMethod.POST)
    public String getFormData(Model model, @Valid @ModelAttribute("userForm") User userForm, final BindingResult errors) {
        userForm.setAuthorities("ROLE_USER");
        userForm.setAccountNonExpired(true);
        userForm.setAccountNonLocked(true);
        userForm.setCredentialsNonExpired(true);
        userForm.setEnabled(true);

        if (StringUtils.hasText(userForm.getEmail()) && userDAO.existsByEmail(userForm.getEmail())) {
            errors.rejectValue("email", "emailAlreadyExists");
        }

        if (StringUtils.isEmpty(userForm.getTelephone())) {
            userForm.setTelephone(null);
        }

        if (StringUtils.hasText(userForm.getUsername()) && userDAO.existsByUsername(userForm.getUsername())) {
            String loginLink = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/login")
                    .build()
                    .toUriString();
            errors.rejectValue("username", "usernameAlreadyExists", new Object[]{loginLink}, null);
        }

        if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "passwordMismatch");
        }

        System.out.println(userForm.getTelephone());
        if (errors.hasErrors()) {
            return "integrated:userInscription";
        }

        String rawPassword = userForm.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userForm.setPassword(encodedPassword);

        userDAO.save(userForm);

        model.addAttribute("email", userForm.getEmail());
        model.addAttribute("username", userForm.getUsername());
        model.addAttribute("password", userForm.getPassword());
        model.addAttribute("firstName", userForm.getFirstName());
        model.addAttribute("lastName", userForm.getLastName());
        model.addAttribute("dateOfBirth", userForm.getDateOfBirth());
        model.addAttribute("telephone", userForm.getTelephone());
        model.addAttribute("address", userForm.getAddress());

        // Authentification automatique après enregistrement
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userForm.getUsername(), rawPassword
        );
        Authentication result = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(result);

        return "redirect:/home";
    }
}

