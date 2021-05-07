package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.CapsuleService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CapsuleService capsuleService;

    @GetMapping("/product/my")
    @PreAuthorize("isAuthenticated()")
    public String getMyProduct(ModelMap map, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        map.addAttribute("user", "");
        map.addAttribute("products", productService.getCurrentUserProducts(userDetails.getId()));
        return "product";
    };

    @GetMapping("/product/{type}")
    public String getProductPage(@PathVariable String type, ModelMap map, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals("anonymousUser")) {
            map.addAttribute("user", "");
            map.addAttribute("capsules", capsuleService.getCapsules(userDetails.getId()));
        }
        map.addAttribute("products", productService.getProductByType(type));
        return "product";
    };

}
