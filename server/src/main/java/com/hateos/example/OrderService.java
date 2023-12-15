package com.hateos.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public List<Order> getAllOrdersForCustomer(String customerId) {
        return List.of(
                Order.builder()
                        .orderId("1")
                        .price(23)
                        .build(),
                Order.builder()
                        .orderId("2")
                        .price(23)
                        .build()
        );

    }

    public Order findByIds() {
        return Order.builder()
                .orderId("1")
                .price(23)
                .build();
    }
}
