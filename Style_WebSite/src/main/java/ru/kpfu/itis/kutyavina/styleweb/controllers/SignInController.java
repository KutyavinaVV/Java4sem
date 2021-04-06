package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String getSignInPage() {
      return "signin";
    }
}
