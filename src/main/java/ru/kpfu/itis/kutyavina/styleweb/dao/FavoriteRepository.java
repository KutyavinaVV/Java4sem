package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.kutyavina.styleweb.models.Title;

public interface FavoriteRepository extends JpaRepository<Title, Long> {

    @Query(value = "SELECT name, id FROM title INNER JOIN user_title ut on title.id = ut.title_id WHERE title.name = ?1 and user_id = ?2", nativeQuery = true)
    Title isFavorite(String name, long userId);
    Title getByName(String name);
}
