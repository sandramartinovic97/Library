package com.library.library.service;

import com.library.library.model.Customer;
import com.library.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImplementation implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    /*@Override
    public Customer getOne(Integer id) {
        return customerRepository.getOne(id);

    }*/

    @Override
    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        //Cascade delete - kad obrisem kupca, obrisi i oznacene(favourite) knjige i porudzbine koje je napravio
        jdbcTemplate.execute("delete from Favourite_Book where customer_id = "+id);
        //   Sara treba da doda customer_id u Book_Order model
        //   jdbcTemplate.execute("delete from Book_Order where customer_id = "+id);

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
