package com.example.springboot_demo.models.dto;

import com.example.springboot_demo.models.User;

public class UserDto {
    private String title;
    private User user;

    public UserDto(){}

    public UserDto(User user, String title) {
        this.title = title;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
