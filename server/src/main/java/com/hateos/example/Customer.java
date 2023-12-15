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
public class Customer extends RepresentationModel<Customer> {
    private String customerId;
    private String customerName;
    private String companyName;

}
