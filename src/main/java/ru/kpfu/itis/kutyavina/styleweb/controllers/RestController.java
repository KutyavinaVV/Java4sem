package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.servise.FavoriteService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

import java.util.Map;

@Controller
public class RestController {

    @Autowired
    ProductService productService;

    @Autowired
    FavoriteService favoriteService;

    @PutMapping("/product/add")
    @ResponseBody
    public void addProductInCap(@RequestParam Map<String,String> params ) {
        productService.addProductInList(
                Long.parseLong(params.get("capsuleId")),
                Long.parseLong(params.get("productId"))
        );
    }

    @DeleteMapping("/product/remove")
    @ResponseBody
    public void removeProductFromCap(@RequestParam Map<String,String> params ) {
        productService.removeProductFromList(
                Long.parseLong(params.get("capsuleId")),
                Long.parseLong(params.get("productId"))
        );
    }

    @PatchMapping("/favorite/add")
    @ResponseBody
    public void addToFavorite(@RequestParam Map<String, String> params) {
        favoriteService.addFavorite(
                Long.parseLong(params.get("userId")),
                params.get("name")
        );
    }

    @DeleteMapping("/favorite/remove")
    @ResponseBody
    public void removeFromFavorite(@RequestParam Map<String, String> params) {
        favoriteService.removeFavorite(
                Long.parseLong(params.get("userId")),
                params.get("name")
        );
    }

}
