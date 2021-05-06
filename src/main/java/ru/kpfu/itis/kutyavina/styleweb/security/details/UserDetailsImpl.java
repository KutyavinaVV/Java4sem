package ru.kpfu.itis.kutyavina.styleweb.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("User");
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }

    public List<Capsule> getCapsule() {
        return user.getCapsuleList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setName(String name) {
        user.setName(name);
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "user=" + user +
                '}';
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}