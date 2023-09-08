package com.example.simpleservice.controllers;

import com.example.simpleservice.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    Response newEmployee() {
        return new Response();
    }

}
