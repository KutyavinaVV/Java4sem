package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;
import ru.kpfu.itis.kutyavina.styleweb.servise.CapsuleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CapsuleController {

    @Autowired
    CapsuleService capsuleService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/capsule/{id}")
    @PreAuthorize("isAuthenticated()")
    public String getCapsule(@PathVariable("id") Capsule capsule, ModelMap modelMap, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletRequest request) {
        Long userId = userDetails.getId();
        appointmentService.removeUnNeeded(userId);
        System.out.println(capsule.toString());
        modelMap.addAttribute("user", userDetails);
        modelMap.addAttribute("capsule", capsule);
        modelMap.addAttribute("appointments", appointmentService.getAllByUserId(userId));
        return (capsule.getOwner().getId() == userId ) ? "capsule" : "redirect:/profile";
    }

    @PostMapping("/capsule/create")
    public String createCapsule(CapsuleForm capsuleForm, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletRequest request) {
        capsuleService.createCapsule(capsuleForm, userDetails.getId());
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @PostMapping("/capsule/updatename")
    public String updateCpasuleName(@RequestParam Map<String,String> params, HttpServletRequest request) {
        capsuleService.updateName(params.get("name"), Long.parseLong(params.get("capsuleId")));
        return "redirect:"+ request.getHeader("Referer");
    }

    @PostMapping("/capsule/remove")
    public String removeCapsule(@RequestParam Map<String,String> params, HttpServletRequest request) {
        capsuleService.removeCapsule(Long.parseLong(params.get("capsuleId")), params.get("say"));;
        return "redirect:"+ request.getHeader("Referer");
    }
}
