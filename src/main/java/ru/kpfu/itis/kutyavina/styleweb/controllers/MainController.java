package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductServiceImpl;

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
