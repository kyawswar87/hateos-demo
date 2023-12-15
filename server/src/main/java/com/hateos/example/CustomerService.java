package com.hateos.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    List<Customer> customerList = List.of(
            new Customer("1","kyawswa","truemoney"),
            new Customer("2","kyawswa","cdsg"),
            new Customer("3","kyawswa","techfun"),
            new Customer("4","kyawswa","KBZ")
    );

    public Customer getCustomerDetail(String customerId) {
        return customerList.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findAny().get();
    }

    public List<Customer> allCustomers() {
        return customerList;
    }
}
