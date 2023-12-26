package com.article.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String KEY="itarticle";
    /*生成token*/
    public static String genToken(Map<String,Object> claims){
        String token = JWT.create()
                .withClaim("claims", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
                .sign(Algorithm.HMAC256(KEY));//指定算法，配置密钥
        return token;
    }
    /*对token进行解密*/
    public static Map<String, Object> parseJwt(String token){
        return JWT.require(
                Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
