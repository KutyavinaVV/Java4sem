package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
