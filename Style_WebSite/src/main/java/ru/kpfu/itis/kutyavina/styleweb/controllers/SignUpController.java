package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.kutyavina.styleweb.dto.UserForm;
import ru.kpfu.itis.kutyavina.styleweb.servise.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @GetMapping("/signup")
    public String getSingUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String singUp(ModelMap model, UserForm userForm) {
        try {
            signUpService.CheckData(userForm);
        }
        catch (IllegalArgumentException ex) {
            model.put("error", ex.getMessage());
            return "signup";
        }
        signUpService.SignUp(userForm);
        return "redirect:/signin";
    }

}
