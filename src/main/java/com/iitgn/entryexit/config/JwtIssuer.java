package com.iitgn.entryexit.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class JwtIssuer {
    public String issue(long userId, String email, List<String> roles){
        return JWT.create().withSubject(String.valueOf(userId)).withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS))).withClaim("e", email).withClaim("a", roles).sign(Algorithm.HMAC256("secret"));
    }
}
