package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.logging.Logging;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;
import ru.kpfu.itis.kutyavina.styleweb.servise.CapsuleService;
import ru.kpfu.itis.kutyavina.styleweb.servise.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    CapsuleService capsuleService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    @Logging
    @PreAuthorize("isAuthenticated()")
    public String getProfilePage(ModelMap modelMap, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getId();
        appointmentService.removeUnNeeded(userId);
        modelMap.addAttribute("user", userDetails);
        modelMap.addAttribute("capsules", capsuleService.getCapsules(userId));
        modelMap.addAttribute("appointments", appointmentService.getAllByUserId(userId));
        return "profile";
    }

    @PostMapping("/changename")
    @PreAuthorize("isAuthenticated()")
    public String changeName(@RequestBody String name, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.updateUser(name, userDetails);
        return "redirect: ";
    }

    @PostMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public String deleteUser(@RequestParam("delete") String delete, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.delete(userDetails.getId(), delete) ?
         "redirect:http://localhost:8080/logout" :  "redirect:http://localhost:8080/profile";
    }

}

