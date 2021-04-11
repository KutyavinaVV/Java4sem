package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.kutyavina.styleweb.logging.Logging;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    @Logging
    @PreAuthorize("isAuthenticated()")
    public String getProfilePage() {
        return "profile";
    }

}
