package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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
    public User updateUser(String data, UserDetailsImpl userDetails) {
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
        return false;
    }

    @Override
    public User findUser(Long id) {
        return usersRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }


}
