package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AboutRestController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/about/data")
    @ResponseBody
    public List<String> getTime(@RequestParam Map<String, String> params) {
        List<String> result = new ArrayList<>();
        try {
            result = appointmentService.checkTime(params.get("date"), params.get("a"));
        }
        catch (IllegalArgumentException e) {
           result.add(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/about/delete")
    @ResponseBody
    public void deleteAppointment(@RequestParam Map<String, String> params) {

    }

}
