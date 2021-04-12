package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.kutyavina.styleweb.logging.Logging;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping("")
    @Logging
    @PreAuthorize("isAuthenticated()")
    public String getProfilePage(ModelMap modelMap, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        modelMap.addAttribute("user", userDetails);
        System.out.println(userDetails.toString());
        return "profile";
    }

    @PostMapping("/changename")
    @PreAuthorize("isAuthenticated()")
    public String changeName(@RequestBody String name, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.updateIdol(name, userDetails);
        return "redirect: ";
    }

    //todo: redirect and say yes
    @PostMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public String deleteUser(@RequestBody String data, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.delete(userDetails.getId());
        return "redirect:http://localhost:8080/logout";
    }

}

