package ru.kpfu.itis.kutyavina.styleweb.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }
}
