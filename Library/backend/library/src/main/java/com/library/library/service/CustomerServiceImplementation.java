package com.library.library.service;

import com.library.library.model.Customer;
import com.library.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImplementation implements  CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
