package ru.kpfu.itis.kutyavina.styleweb.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import ru.kpfu.itis.kutyavina.styleweb.logging.LoggingAspect;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.utils.StringConverter;

import java.util.Locale;
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

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
        res.setBasenames("classpath:i18n/messages", "classpath:i18n/validation");
        res.setCacheSeconds(0);
        res.setDefaultEncoding("UTF-8");
        res.setUseCodeAsDefaultMessage(false);
        return res;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("lang");
        localeResolver.setDefaultLocale(new Locale("en", "US"));
        return localeResolver;
    }

}
