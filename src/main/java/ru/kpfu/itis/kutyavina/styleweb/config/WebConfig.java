package ru.kpfu.itis.kutyavina.styleweb.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.kutyavina.styleweb.logging.LoggingAspect;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.utils.StringConverter;

import java.util.logging.Logger;

@Configuration
public class WebConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Logger logger() {
        return Logger.getLogger(LoggingAspect.class.getName());
    }

    @Bean
    public StringConverter idolGenericConverter(){
        return new StringConverter(Capsule.class);
    }

}
