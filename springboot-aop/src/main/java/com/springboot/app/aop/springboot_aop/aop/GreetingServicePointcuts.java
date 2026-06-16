package com.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.springboot.app.aop.springboot_aop.services.IGreetingService.*(..))")
    public void greetingLoggerPointcut(){}

    @Pointcut("execution(* com.springboot.app.aop.springboot_aop.services.IGreetingService.*(..))")
    public void greetingFooLoggerPointcut(){}
}
