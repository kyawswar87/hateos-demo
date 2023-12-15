package com.hateos.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.hateoas.RepresentationModel;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order extends RepresentationModel<Order> {
    private String orderId;
    private double price;
    private int quantity;

}
