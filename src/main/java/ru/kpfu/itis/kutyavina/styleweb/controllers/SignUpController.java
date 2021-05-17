package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.kutyavina.styleweb.dto.UserForm;
import ru.kpfu.itis.kutyavina.styleweb.servise.SignUpService;

import javax.annotation.security.PermitAll;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class SignUpController {

    @Autowired
    Logger logger;

    @Autowired
    SignUpService signUpService;

    @PermitAll
    @GetMapping("/signup")
    public String getSingUpPage(Authentication authentication) {
        return authentication == null ?  "signup" :  "profile";
    }

    @PostMapping("/signup")
    public String singUp(ModelMap model, UserForm userForm) {
        try {
            signUpService.CheckData(userForm);
        }
        catch (IllegalArgumentException ex) {
            model.put("error", ex.getMessage());
            // logger.log(Level.SEVERE, "wrong parameters for sign up", ex );
            return "signup";
        }
        signUpService.SignUp(userForm);
        return "redirect:/signin";
    }

}
