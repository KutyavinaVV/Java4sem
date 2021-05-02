package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;

import java.util.Map;

@Controller
public class AboutRestController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/about/data")
    @ResponseBody
    public void getTime(@RequestParam Map<String, String> params) {
        String date = params.get("date");
        String a = params.get("a");
        System.out.println(params);
        System.out.println(date + " " + a);
        try {
            System.out.println(appointmentService.checkTime(date, a));
        }
        catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
        }

    }
}
