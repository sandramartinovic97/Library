package com.library.library.controller;

import com.library.library.model.Customer;
import com.library.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable ("id") Integer id){
        if(!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable("id") Integer id) {
        if (!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.updateCustomer(customer,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
