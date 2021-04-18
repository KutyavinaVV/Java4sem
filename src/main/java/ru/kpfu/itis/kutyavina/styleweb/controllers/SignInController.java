package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class SignInController {

    @GetMapping("/signin")
    @PermitAll
    public String getSignInPage(Authentication authentication) {
        return authentication == null ?  "signin" :  "profile";
    }
}
