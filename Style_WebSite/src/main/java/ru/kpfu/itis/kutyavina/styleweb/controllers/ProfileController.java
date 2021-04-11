package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.kutyavina.styleweb.logging.Logging;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    @Logging
    public String getProfilePage() {
        return "profile";
    }

}
