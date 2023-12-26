package com.article.controller;

import com.article.entity.Result;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import com.article.utils.JwtUtil;
import com.article.utils.Md5Util;
import com.auth0.jwt.JWT;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserProperties userProperties;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String userName,@Pattern(regexp = "^\\S{5,16}$")String password){
        User user = User.builder().name(userName).password(Md5Util.encryptToMD5(password)).build();
        User u = userService.queryOne(user);
        if (u == null){
            userService.register(user);
            return Result.success();
        }else {
            return Result.error("用户名已存在");
        }
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String userName,@Pattern(regexp = "^\\S{5,16}$")String password){
        User user = User.builder().name(userName).password(password).build();
        User loginUser = userService.queryByName(user);
        if (loginUser == null){
            return Result.error("用户名错误");
        }
        if (Md5Util.encryptToMD5(password) .equals(loginUser.getPassword())){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("userName",loginUser.getName());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
}
