package com.example.orderservice.service;

import com.example.orderservice.exceptions.NotFoundRuntimeException;
import com.example.orderservice.exceptions.UniqueRequestRuntimeException;
import com.example.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.openapitools.model.Order;
import org.openapitools.model.OrderProduct;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public Order changeOrder(String xUserID, Long orderId, Order order) {
        Order issetOrder = findById(orderId);
        issetOrder.getOrderProducts().clear();
        issetOrder.getOrderProducts().addAll(order.getOrderProducts());
        return orderRepository.save(issetOrder);
    }

    @Override
    public Order createOrder(String xUserID, String xRequestID, Order order) {
        checkUniqueRequestId(xRequestID);
        order.setUserId(Long.valueOf(xUserID));
        order.setRequestId(xRequestID);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String xUserID, Long orderId) {
        Order order = findById(orderId);
        orderRepository.deleteById(order.getId());
    }

    @Override
    public Order getOrder(String xUserID, Long orderId) {
        return findById(orderId);
    }

    private Order findById(Long orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()){
            throw new NotFoundRuntimeException();
        }
        return order.get();
    }

    private void checkUniqueRequestId(String xRequestID){
        orderRepository.findAll().forEach(order -> {
            if(order.getRequestId().equals(xRequestID)){
                throw new UniqueRequestRuntimeException();
            }
        });
    }
}
