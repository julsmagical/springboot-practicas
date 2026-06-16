package com.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Before("execution(* com.springboot.app.aop.springboot_aop..*.*(..))")
    @Before("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName(); 
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName(); 
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + method + " con los argumentos " + args);
    }

    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName(); 
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName(); 
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar excepción: " + method + " con los argumentos " + args);
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointcut()")
    public Object loggerAound(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try{
            logger.info("El método " + method + "() con los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El método " + method + "() retorna el resultado: " + result);
            return result;
        }catch(Throwable ex){
            logger.error("Error al llamar al método " + method + "()");
            throw ex;
        }
    }
}
