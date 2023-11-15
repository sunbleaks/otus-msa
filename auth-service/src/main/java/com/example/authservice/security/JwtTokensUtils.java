package com.example.authservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtTokensUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.accessToken.lifetime}")
    private Duration jwtAccessTokenLifetime;

    public String generateAccessToken(UserDetails userDetails, long userId){
        Map<String, Object> claims = new HashMap<>();
        List<String> roleList = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        claims.put("roles", roleList);

        Date issueDate = new Date();
        Date expiredDate = new Date(issueDate.getTime() + jwtAccessTokenLifetime.toMillis());

        byte[] keyBytes = secret.getBytes();
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .id(String.valueOf(userId))
                .issuedAt(issueDate)
                .expiration(expiredDate)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims getAllClaimsFromToken(String token){

        byte[] bytes =  secret.getBytes();
        SecretKey secretKey = Keys.hmacShaKeyFor(bytes);

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parse(token)
                .accept(Jws.CLAIMS).getPayload();
    }

    public String getId(String token){
        return getAllClaimsFromToken(token).getId();
    }

    public String getUsername(String token){
        return getAllClaimsFromToken(token).getSubject();
    }

    public List<String> getRoles(String token){
        return getAllClaimsFromToken(token).get("roles", List.class);
    }

}
