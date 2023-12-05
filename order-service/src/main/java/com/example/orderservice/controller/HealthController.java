package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
