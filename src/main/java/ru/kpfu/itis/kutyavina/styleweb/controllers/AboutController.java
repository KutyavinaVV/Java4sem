package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.kutyavina.styleweb.servise.TimeService;

import java.text.ParseException;

@Controller
public class AboutController {

    @Autowired
    TimeService timeService;

    @GetMapping("/about")
    @PreAuthorize("isAuthenticated()")
    public String getAbout(ModelMap modelMap) {
        modelMap.put("maxDate", timeService.getMaxDate());
        modelMap.put("date", timeService.getTodayDay());
        modelMap.put("today", timeService.getTodayDay());
        return "about";
    }




}
