package com.library.library.service;

import com.library.library.model.Customer;

import java.util.Collection;

public interface CustomerService {
    public Collection<Customer> getAllCustomers();

   // public Customer getOne(Integer id);

    public boolean existsById(Integer id);

    public void deleteById(Integer id);

    public void save(Customer customer);

    public Customer getCustomerById(Integer id);
}
