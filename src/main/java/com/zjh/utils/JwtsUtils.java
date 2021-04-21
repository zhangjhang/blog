package com.zjh.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtsUtils {

    //生成token 加密
    public String generateToken(String inputPass){
        String token = Jwts.builder()
                .setSubject(inputPass)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "1a2a3a")
                .compact();
        return token;


    }

    //解密根据盐
    public String parserToken(String token){
        Claims body = Jwts.parser()
                .setSigningKey("1a2a3a")
                .parseClaimsJws(token)
                .getBody();

        return body.getSubject();
    }
}
