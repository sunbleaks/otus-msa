package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.openapitools.api.OrderApi;
import org.openapitools.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> changeOrder(String xUserID, Long orderId, Order order) {
        return new ResponseEntity<>(orderService.changeOrder(xUserID, orderId, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> createOrder(String xUserID, String xRequestID, Order order) {
        return new ResponseEntity<>(orderService.createOrder(xUserID, xRequestID, order), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(String xUserID, Long orderId) {
        orderService.deleteOrder(xUserID, orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> getOrder(String xUserID, Long orderId) {
        return new ResponseEntity<>(orderService.getOrder(xUserID, orderId), HttpStatus.OK);
    }
}
