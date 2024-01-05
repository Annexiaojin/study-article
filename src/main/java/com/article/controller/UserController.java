package com.article.controller;

import com.article.entity.Result;
import com.article.entity.User;
import com.article.properties.UserProperties;
import com.article.service.UserService;
import com.article.utils.JwtUtil;
import com.article.utils.Md5Util;
import com.article.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserProperties userProperties;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
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
    public Result<String> login(@Pattern(regexp = "^\\S{3,16}$") String userName,@Pattern(regexp = "^\\S{5,16}$")String password){
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
            stringRedisTemplate.opsForValue().set(token,token,1, TimeUnit.HOURS);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader("Authorization") String token*/){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        User user = User.builder().name(username).build();
        User user1 = userService.queryByName(user);
        return Result.success(user1);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvator")
    public Result updateAvator(@RequestParam("avatorUrl") @URL String url){
        userService.updateAvator(url);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params, @RequestHeader("Authorization") String token){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("参数未填写完成");
        }
//        校验旧密码
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        User user1 = User.builder().name(userName).build();
        User user = userService.queryByName(user1);
        if (!user.getPassword().equals(Md5Util.encryptToMD5(oldPwd))){
            return Result.error("原密码填写错误");
        }
        if (! newPwd.equals(rePwd)){
            return Result.error("两次密码填写不一致");
        }
        userService.updatePwd(newPwd);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }
}
