package ru.kpfu.itis.kutyavina.styleweb.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private Logger logger;


    @Pointcut("@annotation(Logging)")
    public void pointCutMethods() {
    }

    @After("pointCutMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        String method = joinPoint.getSignature().getName() + " " + name;
        logger.log(Level.WARNING, method);
    }
}
