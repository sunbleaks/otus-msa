package com.example.authservice.controllers;

import com.example.authservice.dto.UserDto;
import com.example.authservice.exceptions.AppError;
import com.example.authservice.security.JwtToken;
import com.example.authservice.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    /*
    * регистрация
    * */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto){
        authService.signup(userDto);
        return ResponseEntity.ok().build();
    }

    /*
     * вход + генерауия токена
     * */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        JwtToken jwtResponse = authService.login(userDto);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    /*
     * проверить по токену данные о пользователе
     * */
    @GetMapping("/token")
    public ResponseEntity<?> token(Authentication authentication){
        if(authentication!=null)
            return new ResponseEntity<>(authentication, HttpStatus.OK);
        else
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                    "error authentication"), HttpStatus.UNAUTHORIZED);
    }

    /*
     * сообщение - необходимо залогиниться
     * */
    @GetMapping("/signin")
    public ResponseEntity<?> signin(){
        return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                "Please go to login and provide Login/Password"), HttpStatus.UNAUTHORIZED);
    }


}
