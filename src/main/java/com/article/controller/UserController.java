package com.article.controller;

import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserProperties userProperties;
    @RequestMapping("/query")
    public List<User> queryAll(){
        List<User> users = userService.queryAll();
        System.out.println(users);
        return users;
    }
    @RequestMapping("/queryOne/{id}")
    public User queryOne(@PathVariable int id){
        User user = userService.queryOne(id);
        System.out.println(user);
        return user;
    }
    @RequestMapping("/insert")
    void insertUser(){
        userService.insertUser(userProperties);
    }
}
