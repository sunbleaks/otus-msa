package com.example.simpleservice.controllers;

import com.example.simpleservice.exceptions.NotFoundRuntimeException;
import com.example.simpleservice.repository.UserRepository;
import org.openapitools.api.UserApi;
import org.openapitools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController implements UserApi {

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseEntity<Void> createUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> findUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
        throw new NotFoundRuntimeException();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            throw new NotFoundRuntimeException();
        }
    }

    @Override
    public ResponseEntity<Void> updateUser(Long userId, User user) {
        if(userRepository.existsById(userId)){
            user.setId(userId);
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new NotFoundRuntimeException();
        }
    }
}
