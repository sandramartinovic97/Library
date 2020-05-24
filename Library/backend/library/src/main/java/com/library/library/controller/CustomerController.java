package com.library.library.controller;

import com.library.library.dto.CustomerDto;
import com.library.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Collection<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") Integer id){
        return customerService.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable ("id") Integer id){
        if(!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public CustomerDto insertCustomer(@RequestBody CustomerDto customer){
        return customerService.insertCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer,@PathVariable("id") Integer id) {
        if (!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.updateCustomer(customer,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
