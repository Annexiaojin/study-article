package com.article.controller;

import com.article.entity.Result;
import com.article.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result list(@RequestHeader(name = "Authorization")String token, HttpServletResponse response){
        try {
            Map<String, Object> claims = JwtUtil.parseJwt(token);
            return Result.success(claims);
        }catch (Exception e){
            response.setStatus(401);
           return Result.error("未登录");
        }
    }
}
