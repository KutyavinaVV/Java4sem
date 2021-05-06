package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.models.User;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;

public interface UserService {

    User updateUser(String name, UserDetailsImpl userDetails);
    boolean delete(Long id, String delete);
    User findUser(Long id);
}

