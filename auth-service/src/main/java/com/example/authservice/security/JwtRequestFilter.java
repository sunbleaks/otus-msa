package com.example.authservice.security;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokensUtils jwtTokensUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("authorization");

        String userid = null;
        String username = null;
        String jwt = null;

        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            jwt = authHeader.substring(7);

            try {
                username = jwtTokensUtils.getUsername(jwt);
                userid = jwtTokensUtils.getId(jwt);
            } catch (Exception e){
                log.error("err",e);
            }

            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        jwtTokensUtils.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                );
                SecurityContextHolder.getContext().setAuthentication(token);
                response.addHeader("X-User-Id", userid);
                response.addHeader("X-User-Name", username);
            }
        }

        filterChain.doFilter(request, response);

    }
}

