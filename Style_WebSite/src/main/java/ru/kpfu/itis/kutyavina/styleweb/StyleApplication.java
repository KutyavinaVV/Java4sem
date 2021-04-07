package ru.kpfu.itis.kutyavina.styleweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.kutyavina.styleweb.logging.LoggingAspect;

import java.util.logging.Logger;

@SpringBootApplication
public class StyleApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Logger logger() {
        return Logger.getLogger(LoggingAspect.class.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(StyleApplication.class, args);
    }

}
