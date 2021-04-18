package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.models.User;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;

import java.util.List;

public interface UserService {

    User updateIdol(String name, UserDetailsImpl userDetails);

    boolean delete(Long id, String delete);
}

