package com.example.appservice.controllers;

import com.example.appservice.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HealthController {

    @GetMapping("/health")
    Response newEmployee() {
        return new Response();
    }

    @GetMapping("/api/a")
    String method1() throws InterruptedException {
        return doSomthing("method1", 0, 1000);
    }

    @GetMapping("/api/b")
    String method2() throws InterruptedException {
        return doSomthing("method2", 0, 1000);
    }

    private Random random = new Random(42);

    //задержка ответа
    private String doSomthing(String res, int from, int to) throws InterruptedException {
        var timeout = random.nextLong(from, to);
        Thread.sleep(timeout);
        return res+": "+timeout;
    }

}
