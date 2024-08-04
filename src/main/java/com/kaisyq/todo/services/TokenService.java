package com.kaisyq.todo.services;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenService {

    private static final long ACCESS_EXPIRATION_TIME = 3600;
    private static final long REFRESH_EXPIRATION_TIME = 604800000; 

    private static final String key = "some_key";

    public String generateAccessToken(String username) {
        final var claims = Jwts.claims().setSubject(username);
    
        final var now = new Date();
        final var expiration = new Date(now.getTime() + ACCESS_EXPIRATION_TIME);

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS512, key)
            .compact()
        ;
    }

    public String generateRefreshToken(String username) {
        final var claims = Jwts.claims().setSubject(username);
    
        final var now = new Date();
        final var expiration = new Date(now.getTime() + REFRESH_EXPIRATION_TIME);

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SignatureAlgorithm.HS512, key)
            .compact()
        ;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
