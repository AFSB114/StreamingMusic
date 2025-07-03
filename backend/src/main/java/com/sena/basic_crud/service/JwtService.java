package com.sena.basic_crud.service;

import com.sena.basic_crud.model.User;
import com.sena.basic_crud.repository.IToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private final IToken iToken;
    @Value("${spring.security.jwt.secret-key}")
    private String secretKey;

    @Value("${spring.security.jwt.expiration}")
    private Long tokenExpiration;

    @Value("${spring.security.jwt.refresh-token.expiration}")
    private Long refreshTokenExpiration;

    public JwtService(IToken iToken) {
        this.iToken = iToken;
    }

    public String generateToken(User user){
        return buildToken(user, tokenExpiration);
    }

    public String generateRefreshToken(User user){
        return buildToken(user, refreshTokenExpiration);
    }

    private String buildToken(User user, Long expiration) {
        return Jwts.builder()
                .id(user.getIdString())
                .claims(Map.of("name", user.getName()))
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        byte[] encodedKey = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(encodedKey);
    }

    public String extractUserEmail(String refreshToken) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(refreshToken)
                .getPayload();
        return claims.getSubject();
    }

    public boolean isTokenValid(String token, User user) {
        String email = extractUserEmail(token);
        return email.equals(user.getEmail()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extracExpiration(token).before(new Date());
    }

    private Date extracExpiration(String token) {
        Claims jwtToken = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return jwtToken.getExpiration();
    }
}
