package com.example.authservice.services;

import com.example.authservice.dto.UserDto;
import com.example.authservice.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findByUsername(String username);
    void save(UserDto userDto);

}
