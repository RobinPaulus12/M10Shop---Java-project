package com.spring.henallux.javaProjectB3.controller;

import com.spring.henallux.javaProjectB3.dataAccess.dao.*;
import com.spring.henallux.javaProjectB3.Constants;
import com.spring.henallux.javaProjectB3.model.ProductCategory;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@RequestMapping(value="/myAccount/myInformations")
@SessionAttributes({Constants.CURRENT_USER})
public class UserInformationsController extends SuperController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        return userDAO.findByUsername(username); // Charger les données de l'utilisateur
    }

    private UserDataAccess userDAO;
    private PasswordEncoder passwordEncoder;
    private ProductCategoryDataAccess productCategoryDAO;
    private MessageSource messageSource;

    @Autowired
    public UserInformationsController(TranslationDAO translationDAO, UserDAO userDAO, PasswordEncoder passwordEncoder, ProductCategoryDAO productCategoryDAO, MessageSource messageSource) {
        super(translationDAO);
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.productCategoryDAO = productCategoryDAO;
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUserInformations(@ModelAttribute(Constants.CURRENT_USER) User user, Model model) {
        model.addAttribute("productCategory",super.getTranslationsByCurrentLocale());
        model.addAttribute("currentUser", user); // Injecter les données dans le formulaire
        return "integrated:userInformations";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateUserInformation(@Valid @ModelAttribute(Constants.CURRENT_USER) User user,
                                        BindingResult bindingResult,
                                        Model model,
                                        RedirectAttributes redirectAttributes) {

        boolean passwordUpdateRequested = StringUtils.hasText(user.getCurrentPassword());

        if (passwordUpdateRequested) {
            if (!StringUtils.hasText(user.getNewPassword()) || !StringUtils.hasText(user.getConfirmNewPassword())) {
                bindingResult.rejectValue("newPassword", "newPasswordRequired");
            } else if (!user.getNewPassword().equals(user.getConfirmNewPassword())) {
                bindingResult.rejectValue("confirmNewPassword", "newPasswordMismatch");
            } else {
                User existingUser = userDAO.findByUsername(user.getUsername());
                if (existingUser != null && !passwordEncoder.matches(user.getCurrentPassword(), existingUser.getPassword())) {
                    bindingResult.rejectValue("currentPassword", "wrongCurrentPassword");
                } else {
                    String encodedPassword = passwordEncoder.encode(user.getNewPassword());
                    user.setPassword(encodedPassword);
                }
            }
        }

        if (StringUtils.hasText(user.getEmail()) && userDAO.existsByEmail(user.getEmail()) && !user.getEmail().equals(userDAO.findByUsername(user.getUsername()).getEmail())) {
            bindingResult.rejectValue("email", "emailAlreadyExists");
        }

        if (StringUtils.isEmpty(user.getTelephone())) {
            user.setTelephone(null);
        }

        if (bindingResult.hasErrors()) {
            List<ProductCategory> categories = productCategoryDAO.findAll();
            model.addAttribute("productCategory", categories);
            return "integrated:userInformations";
        }

        userDAO.save(user);

        String successMessage = messageSource.getMessage("userInformationsUpdateSuccess", null, LocaleContextHolder.getLocale());
        redirectAttributes.addFlashAttribute("success", successMessage);

        return "redirect:/myAccount/myInformations";
    }

}
