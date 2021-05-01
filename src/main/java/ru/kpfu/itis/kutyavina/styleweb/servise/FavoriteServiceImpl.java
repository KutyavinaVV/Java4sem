package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.FavoriteRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Title;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    UserService userService;

    @Override
    public boolean isFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.isFavorite(titleName, userId);
        System.out.println(title);
        return title != null;
    }

    @Override
    public void addFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.getByName(titleName);
        title.getFavourFor().add(userService.findUser(userId));
        favoriteRepository.save(title);
    }

    @Override
    public void removeFavorite(Long userId, String titleName) {
        Title title = favoriteRepository.getByName(titleName);
        title.getFavourFor().remove(userService.findUser(userId));
        favoriteRepository.save(title);
    }
}
