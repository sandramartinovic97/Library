package com.library.library.controller;

import com.library.library.model.Customer;
import com.library.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
