package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.CapsuleService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CapsuleService capsuleService;

    @GetMapping("/product/{type}")
    public String getProductPage(@PathVariable String type, ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals("anonymousUser")) map.addAttribute("auth", "");
        map.addAttribute("products", productService.getProductByType(type));
        return "product";
    };

    @PostMapping("/capsule/create")
    public String createCapsule(CapsuleForm capsuleForm,  @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletRequest request) {
        capsuleService.createCapsule(capsuleForm, userDetails.getId());

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
