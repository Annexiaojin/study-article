package com.article.controller;

import com.article.entity.Result;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/insert")
    void insertUser(){
        userService.insertUser(userProperties);
    }
    @PostMapping("/register")
    public Result register(String userName,String password){
        User user = User.builder().name(userName).password(password).build();
        User u = userService.queryOne(user);
        if (u == null){
            return Result.success();
        }else {
            return Result.error("用户名已存在");
        }
    }
}
