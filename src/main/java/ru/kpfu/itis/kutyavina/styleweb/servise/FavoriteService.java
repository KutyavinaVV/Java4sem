package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.FavoriteRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Title;

@Service
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    UserService userService;

    public boolean isFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.isFavorite(titleName, userId);
        return title != null;
    }

    public void addFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.getByName(titleName);
        title.getFavourFor().add(userService.findUser(userId));
        favoriteRepository.save(title);
    }

    public void removeFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.getByName(titleName);
        title.getFavourFor().remove(userService.findUser(userId));
        favoriteRepository.save(title);
    }
}
