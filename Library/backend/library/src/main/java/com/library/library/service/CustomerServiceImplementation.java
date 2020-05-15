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
    @Override
    public Customer getOne(Integer id) {
        return customerRepository.getOne(id);

    }

    @Override
    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }
}
