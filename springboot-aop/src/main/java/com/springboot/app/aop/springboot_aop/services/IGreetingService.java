package com.springboot.app.aop.springboot_aop.services;

public interface IGreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
