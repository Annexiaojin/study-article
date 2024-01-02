package com.article;

import com.article.entity.User;
import com.article.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyArticleApplicationTests {
   @Test
    public void testJwt(){
       Map<String, Object> claims = new HashMap<>();
       claims.put("id",1);
       claims.put("username","张三");
       String token = JWT.create()
               .withClaim("user", claims)//添加载荷
               .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
               .sign(Algorithm.HMAC256("itarticle"));//指定算法，配置密钥
       System.out.println(token);
   }
   @Test
    public void tokenVerify(){
       String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
               ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MDM1Mzg3MTl9" +
               ".941fTjwHvhRWIVRyF73zDlPh1as8X5Fj5O95nz51nRQ";
       JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itarticle")).build();
       DecodedJWT decodedJWT = jwtVerifier.verify(token);
       Map<String, Claim> claims = decodedJWT.getClaims();
       System.out.println(claims.get("user"));
   }
   @Test
   public void ThreadLocalSetAndGet(){
      ThreadLocal<Object> t1 = new ThreadLocal<>();
      new Thread(()->{
         t1.set("小陈");
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
      },"蓝色").start();
      new Thread(()->{
         t1.set("小王");
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
         System.out.println(Thread.currentThread().getName()+":"+t1.get());
      },"红色").start();
   }

}
