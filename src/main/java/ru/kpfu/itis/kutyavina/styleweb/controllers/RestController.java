package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentService;
import ru.kpfu.itis.kutyavina.styleweb.servise.FavoriteService;
import ru.kpfu.itis.kutyavina.styleweb.servise.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class RestController {

    @Autowired
    ProductService productService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    Logger logger;

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

    @GetMapping("/about/data")
    @ResponseBody
    public List<String> getTime(@RequestParam Map<String, String> params) {
        List<String> result = new ArrayList<>();
        try {
            result = appointmentService.checkTime(params.get("date"), params.get("a"));
        }
        catch (IllegalArgumentException e) {
            result.add(e.getMessage());
            logger.log(Level.SEVERE, "wrong date", e );
        }
        return result;
    }

    @DeleteMapping("/about/delete")
    @ResponseBody
    public void deleteAppointment(@RequestParam String id) {
        appointmentService.removeAppointment(Long.parseLong(id));
    }

}
