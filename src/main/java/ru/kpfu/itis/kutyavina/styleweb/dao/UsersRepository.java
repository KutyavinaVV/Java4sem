package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
