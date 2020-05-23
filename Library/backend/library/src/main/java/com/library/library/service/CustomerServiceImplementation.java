package com.library.library.service;

import com.library.library.dto.CustomerDto;
import com.library.library.model.Customer;
import com.library.library.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomerServiceImplementation implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public Collection<CustomerDto> getAllCustomers() {

        Collection<Customer> customers = customerRepository.findAll();
        Collection<CustomerDto> customersDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customersDtos.add(customerDto);
        }
        return customersDtos;
    }

    @Override
    public CustomerDto getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find customer with specified id="+id));
        return modelMapper.map(customer, CustomerDto.class);

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
    public CustomerDto insertCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer id) {
        Customer updatedCustomer = modelMapper.map(customerDto, Customer.class);
        Customer customerFromDB=customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find customer with specified id=" + id));
        customerFromDB.setCustomerName(updatedCustomer.getCustomerName());
        customerFromDB.setCustomerSurname(updatedCustomer.getCustomerSurname());
        customerFromDB.setCustomerGender(updatedCustomer.getCustomerGender());
        customerFromDB.setCustomerPhoneNum(updatedCustomer.getCustomerPhoneNum());
        customerFromDB.setCustomerEmail(updatedCustomer.getCustomerEmail());
        customerFromDB.setCustomerCountry(updatedCustomer.getCustomerCountry());
        customerFromDB.setCustomerCity(updatedCustomer.getCustomerCity());
        customerFromDB.setCustomerStreet(updatedCustomer.getCustomerStreet());
        customerFromDB.setCustomerPassword(updatedCustomer.getCustomerPassword());
        return modelMapper.map(customerRepository.save(customerFromDB), CustomerDto.class);
    }


}
