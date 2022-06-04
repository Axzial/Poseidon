package com.nnk.springboot.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@UtilityClass
public class JwtUtils {
    public static final String SECRET_KEY = "testing";
    // expiration
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days

    // get claims
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(java.sql.Timestamp.from(java.time.Instant.now().plusSeconds(EXPIRATION_TIME)))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject()
                .equals(userDetails.getUsername());
    }

    public String getExpirationTimeFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .toString();
    }

    public String getIssuedTimeFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getIssuedAt()
                .toString();
    }

    public String getIssuerFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getIssuer();
    }

    public String getAudienceFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getAudience();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getSubjectFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
