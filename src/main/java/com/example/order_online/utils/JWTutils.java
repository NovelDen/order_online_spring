package com.example.order_online.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import java.util.Date;

public class JWTutils {
    public static String getToken(String userId, String sign){
        String Token = JWT.create()
                .withAudience(userId)
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                .sign(Algorithm.HMAC256(sign));
        return Token;
    }
}
