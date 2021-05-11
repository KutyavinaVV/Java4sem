package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.security.PermitAll;

@Controller
public class MainController {

    @PermitAll
    @GetMapping("/mainpage")
    public String getMainPage(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals("anonymousUser")) {
            map.addAttribute("user", "");
        }
        return "mainpage";
    }

    @PermitAll
    @GetMapping("/")
    public String root() {

        return "redirect:mainpage";
    }
}
