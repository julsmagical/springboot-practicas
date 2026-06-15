package com.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Julio", "Castro"));
        users.add(new User(2L, "Cesar", "Moran"));
        users.add(new User(3L, "Fernando", "Castañeda"));
        users.add(new User(4L, "Gabriel", "Fernandez"));
        return users;
    }
}
