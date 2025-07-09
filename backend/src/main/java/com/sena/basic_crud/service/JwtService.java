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

    @Value("${spring.security.jwt.recovery-pass.expiration}")
    private Long recoveryPassExpiration;

    public JwtService(IToken iToken) {
        this.iToken = iToken;
    }

    public String generateToken(User user){
        return buildToken(user, tokenExpiration, Map.of("type", "access_token"));
    }

    public String generateRefreshToken(User user){
        return buildToken(user, refreshTokenExpiration);
    }

    public String generateRecoveryPassToken(User user){
        return buildToken(user, recoveryPassExpiration, Map.of("type", "recovery_pass_token"));
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

    private String buildToken(User user, Long expiration, Map<String, Object> claims) {
        return Jwts.builder()
                .id(user.getIdString())
                .claims(claims)
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

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUserEmail(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public String extractTypeToken(String token) {
        return getClaimsFromToken(token).get("type").toString();
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
