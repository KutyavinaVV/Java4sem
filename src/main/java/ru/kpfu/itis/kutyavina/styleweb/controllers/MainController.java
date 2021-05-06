package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.security.PermitAll;

@Controller
public class MainController {

    @PermitAll
    @GetMapping("/mainpage")
    public String getMainPage() {
        return "mainpage";
    }

    @PermitAll
    @GetMapping("/")
    public String root() {
        return "redirect:mainpage";
    }
}
