package ru.kpfu.itis.kutyavina.styleweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    protected ApplicationContext applicationContext;

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftlh");
        resolver.setContentType("text/html;charset=UTF-8");

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/styles/**").addResourceLocations("classpath:/static/styles/");
        registry.addResourceHandler("/static/assets/**").addResourceLocations("classpath:/static/assets/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
    }
}