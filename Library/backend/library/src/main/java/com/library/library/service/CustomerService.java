package com.library.library.service;

import com.library.library.dto.CustomerDto;
import com.library.library.model.Customer;

import java.util.Collection;

public interface CustomerService {
    public Collection<CustomerDto> getAllCustomers();
    public CustomerDto getCustomerById(Integer id);
    public boolean existsById(Integer id);
    public void deleteCustomerById(Integer id);
    public CustomerDto insertCustomer(CustomerDto customer);
    public CustomerDto updateCustomer(CustomerDto customer,Integer id);
}
