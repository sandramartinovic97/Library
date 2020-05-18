package com.library.library.service;

import com.library.library.model.Customer;

import java.util.Collection;

public interface CustomerService {
    public Collection<Customer> getAllCustomers();
    public Customer getCustomerById(Integer id);
    public boolean existsById(Integer id);
    public void deleteCustomerById(Integer id);
    public Customer insertCustomer(Customer customer);
    public Customer updateCustomer(Customer customer,Integer id);
}
