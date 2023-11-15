package com.example.authservice.services;

import com.example.authservice.dto.UserDto;
import com.example.authservice.security.JwtToken;
import org.springframework.security.core.Authentication;

public interface AuthService {
    void signup(UserDto userDto);
    JwtToken login(UserDto userDto);
}
