package com.library.library.service;

import com.library.library.model.BookOrder;
import com.library.library.model.Customer;
import com.library.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find customer with specified id="+id));
    }

    @Override
    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        //Cascade delete - kad obrisem kupca, obrisi i oznacene(favourite) knjige i porudzbine koje je napravio
       jdbcTemplate.execute("delete from Favourite_Book where customer_id = "+id);
       jdbcTemplate.execute("delete from Order_Item " +
               "where (select Order_Item.id from Order_Item join Book_Order on order_id = Book_Order.id where Book_Order.customer_id) = "+id);
       jdbcTemplate.execute("delete from Book_Order where customer_id = "+id);
        customerRepository.deleteById(id);
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) {

        Customer customerFromDB = getCustomerById(id);
        customerFromDB.setCustomerName(customer.getCustomerName());
        customerFromDB.setCustomerSurname(customer.getCustomerSurname());
        customerFromDB.setCustomerGender(customer.getCustomerGender());
        customerFromDB.setCustomerPhoneNum(customer.getCustomerPhoneNum());
        customerFromDB.setCustomerEmail(customer.getCustomerEmail());
        customerFromDB.setCustomerCountry(customer.getCustomerCountry());
        customerFromDB.setCustomerCity(customer.getCustomerCity());
        customerFromDB.setCustomerStreet(customer.getCustomerStreet());
        customerFromDB.setCustomerPassword(customer.getCustomerPassword());
        return customerRepository.save(customerFromDB);
    }


}
