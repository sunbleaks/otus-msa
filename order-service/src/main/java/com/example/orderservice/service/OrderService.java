package com.example.orderservice.service;

import org.openapitools.model.Order;
import org.openapitools.model.OrderProduct;

import java.util.List;

public interface OrderService {
    Order changeOrder(String xUserID, Long orderId, Order order);
    Order createOrder(String xUserID, String xRequestID, Order order);
    void deleteOrder(String xUserID, Long orderId);
    Order getOrder(String xUserID, Long orderId);
}
