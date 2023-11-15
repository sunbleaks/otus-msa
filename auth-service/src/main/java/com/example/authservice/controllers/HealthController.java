package com.example.authservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HealthController {

    @GetMapping("/health")
    Response newEmployee() {
        return new Response();
    }


    class Response {
        public String status = "OK";
    }

}
