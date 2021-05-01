package ru.kpfu.itis.kutyavina.styleweb.servise;

public interface FavoriteService {

    public boolean isFavorite(Long userId, String titleName);
    public void addFavorite(Long userId, String titleName);
    public void removeFavorite(Long userId, String titleName);
}
