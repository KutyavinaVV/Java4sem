package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class MainController {

    @Autowired
    private LocaleResolver localeResolver;

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

    @RequestMapping("/changehome/{locale}")
    public String changeHome(@PathVariable("locale") String locale, HttpServletRequest request, HttpServletResponse response){
        String[] localeData = locale.split("_");
        localeResolver.setLocale(request, response, new Locale(localeData[0], localeData[1]));
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
