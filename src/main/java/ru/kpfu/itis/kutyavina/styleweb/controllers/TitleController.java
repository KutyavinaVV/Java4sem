package ru.kpfu.itis.kutyavina.styleweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;
import ru.kpfu.itis.kutyavina.styleweb.servise.FavoriteService;

@Controller
public class TitleController {

    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/title/{name}")
    public String getTitle(@PathVariable String name, ModelMap map, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            if (favoriteService.isFavorite(userDetails.getId(), name)) map.put("isFavorite", true);
            map.put("name", name);
            map.put("userId", userDetails.getId());
        }
        return name;
    }
}
