package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.dto.AppointmentForm;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;
import ru.kpfu.itis.kutyavina.styleweb.servise.TimeService;

import java.text.ParseException;
import java.util.Map;

@Controller
public class AboutController {

    @Autowired
    TimeService timeService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/about")
    @PreAuthorize("isAuthenticated()")
    public String getAbout(ModelMap modelMap) {
        modelMap.put("maxDate", timeService.getMaxDate());
        modelMap.put("date", timeService.getTodayDay());
        modelMap.put("today", timeService.getTodayDay());
        return "about";
    }

    @PostMapping("/about/add")
    public String addAppointment(AppointmentForm appointmentForm,  @AuthenticationPrincipal UserDetailsImpl userDetails, ModelMap modelMap) {
        appointmentService.addAppointment(appointmentForm, userDetails.getId());
        modelMap.put("notification", "Запись была успешно создана");
        return "redirect:about";
    }


}
