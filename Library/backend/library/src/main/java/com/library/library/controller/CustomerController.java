package com.library.library.controller;

import com.library.library.JwtTokenUtil;
import com.library.library.dto.CustomerDto;
import com.library.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public Collection<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("id") Integer id) {
        if (!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public CustomerDto insertCustomer(@RequestBody CustomerDto customer) {
        return customerService.insertCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer, @PathVariable("id") Integer id) {
        if (!customerService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        customerService.updateCustomer(customer, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/token")
    public CustomerDto getCustomerByToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        CustomerDto customerDto = customerService.getCustomerByUsername(currentPrincipalName);
        return customerDto;
    }

}
