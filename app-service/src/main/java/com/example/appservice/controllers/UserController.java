package com.example.appservice.controllers;

import java.util.Optional;

import org.openapitools.api.UserApi;
import org.openapitools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.appservice.exceptions.NotFoundRuntimeException;
import com.example.appservice.repository.UserRepository;

@RestController
public class UserController implements UserApi {

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseEntity<Void> createUser(String xUserID, String xUserName, User user) {
        user.setId(Long.valueOf(xUserID));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> findUserById(String xUserID, String xUserName) {
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(xUserID));
        if(optionalUser.isPresent()){
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
        throw new NotFoundRuntimeException();
    }

    @Override
    public ResponseEntity<Void> deleteUser(String xUserID, String xUserName) {
        if(userRepository.existsById(Long.valueOf(xUserID))){
            userRepository.deleteById(Long.valueOf(xUserID));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            throw new NotFoundRuntimeException();
        }
    }

    @Override
    public ResponseEntity<User> updateUser(String xUserID, String xUserName, User user) {
        if(userRepository.existsById(Long.valueOf(xUserID))){
            user.setId(Long.valueOf(xUserID));
            user = userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            throw new NotFoundRuntimeException();
        }
    }
}
