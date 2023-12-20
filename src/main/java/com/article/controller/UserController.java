package com.article.controller;

import com.article.entity.User;
import com.article.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/query")
    public List<User> queryAll(){
        List<User> users = userService.queryAll();
        System.out.println(users);
        return users;
    }
}
