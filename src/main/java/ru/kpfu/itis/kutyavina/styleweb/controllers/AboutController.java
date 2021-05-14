package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.dto.AppointmentForm;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;
import ru.kpfu.itis.kutyavina.styleweb.servise.TimeService;

@Controller
public class AboutController {

    @Autowired
    TimeService timeService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/about")
    public String getAbout(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals("anonymousUser")) {
            return "redirect:/about/anon";
        }
        modelMap.put("maxDate", timeService.getMaxDate());
        modelMap.put("date", timeService.getTodayDay());
        modelMap.put("today", timeService.getTodayDay());
        modelMap.put("user", true);
        return "about";
    }

    @GetMapping("/about/anon")
    public String getAboutNoneAuth() {
        return "aboutnone";
    }


    @PostMapping("/about/add")
    public String addAppointment(AppointmentForm appointmentForm,  @AuthenticationPrincipal UserDetailsImpl userDetails, ModelMap modelMap) {
        appointmentService.addAppointment(appointmentForm, userDetails.getId());
        modelMap.put("notification", "Запись была успешно создана");
        return "redirect:/profile";
    }


}
