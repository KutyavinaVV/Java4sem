package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.User;
import ru.kpfu.itis.kutyavina.styleweb.security.details.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public User updateIdol(String data, UserDetailsImpl userDetails) {
        String name = data.split("=")[1];
        User user = usersRepository.findById(userDetails.getId()).orElseThrow(IllegalAccessError::new);
        user.setName(name);
        userDetails.setName(name);
        usersRepository.save(user);
        return user;
    }

    @Override
    public boolean delete(Long id, String delete) {
        if(delete.toLowerCase().equals("yes")) {
            User deleteUser = usersRepository.findById(id).orElseThrow(IllegalAccessError::new);
            usersRepository.delete(deleteUser);
            return true;
        }
        return true;
    }
}
