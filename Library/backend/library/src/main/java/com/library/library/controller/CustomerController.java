package com.library.library.controller;

import com.library.library.model.Customer;
import com.library.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);

    }
    @DeleteMapping("customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable ("id") Integer id){
        if(!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }
  @PostMapping("customer")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        if(!customerService.existsById(customer.getId())){
            customerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @PutMapping("customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        if (!customerService.existsById(customer.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
