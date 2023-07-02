package com.example.demo.logging;

import com.google.gson.JsonObject;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @AfterReturning("execution(* com.example.demo..*(..))")
    public void logUserActivity(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        JsonObject logObject = new JsonObject();
        logObject.addProperty("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        logObject.addProperty("User Action", "Method " + methodName + " in class " + className + " was executed");
        logObject.addProperty("level", "INFO");
        logObject.addProperty("thread", Thread.currentThread().getName());
        logObject.addProperty("logger", this.getClass().getName());
        log.info(logObject.toString());
    }

}
