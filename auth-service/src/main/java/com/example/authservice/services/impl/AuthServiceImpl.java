package com.example.authservice.services.impl;

import com.example.authservice.dto.UserDto;
import com.example.authservice.entities.User;
import com.example.authservice.exceptions.ConfirmPasswordNotMatch;
import com.example.authservice.exceptions.UsernameExists;
import com.example.authservice.exceptions.UsernamePasswordIsEmpty;
import com.example.authservice.security.JwtToken;
import com.example.authservice.security.JwtTokensUtils;
import com.example.authservice.services.AuthService;
import com.example.authservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokensUtils jwtTokensUtils;

    @Override
    public void signup(UserDto userDto) {
        if(userDto.getUsername().isEmpty())
            throw new UsernamePasswordIsEmpty(); //400
        if(userDto.getPassword().isEmpty())
            throw new UsernamePasswordIsEmpty(); //400
        if(!userDto.getPassword().equals(userDto.getPasswordConfirm()))
            throw new ConfirmPasswordNotMatch(); //400
        if(userService.findByUsername(userDto.getUsername()).isPresent())
            throw new UsernameExists(); //400

        userService.save(userDto);
    }

    @Override
    public JwtToken login(UserDto userDto) {
        if(userDto.getUsername().isEmpty())
            throw new UsernamePasswordIsEmpty();
        if(userDto.getPassword().isEmpty())
            throw new UsernamePasswordIsEmpty();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        }catch (AuthenticationException e){
            //401
            throw e;
        }

        UserDetails userDetails = userService.loadUserByUsername(userDto.getUsername());
        User user = userService.findByUsername(userDto.getUsername()).get();

        String accessToken = jwtTokensUtils.generateAccessToken(userDetails, user.getId());

        return new JwtToken(accessToken, "Bearer");
    }

}
