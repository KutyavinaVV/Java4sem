package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

import java.util.Map;

@Controller
public class RestController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseBody
    public void addProductInCap(@RequestParam Map<String,String> params ) {
        productService.addProductInList(Long.parseLong(params.get("capsuleId")),Long.parseLong(params.get("productId")));
    }
}
