package com.library.library.service;

import com.library.library.dto.BookOrderDto;
import com.library.library.dto.CustomerDto;
import com.library.library.model.BookOrder;
import com.library.library.model.Customer;
import com.library.library.repository.BookOrderRepository;
import com.library.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookOrderServiceImplementation implements BookOrderService {
    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<BookOrderDto> getAllOrders() {
        Collection<BookOrder> bookOrders = bookOrderRepository.findAll();
        Collection<BookOrderDto> bookOrdersDto = new ArrayList<>();
        for (BookOrder bookOrder : bookOrders) {
            BookOrderDto bookOrderDto = entityToDto(bookOrder);
            bookOrdersDto.add(bookOrderDto);
        }
        return bookOrdersDto;
    }

    @Override
    public BookOrderDto getOrderById(Integer id) {
        BookOrder bookOrder = bookOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book order with specified id=" + id));
        BookOrderDto bookOrderDto = entityToDto(bookOrder);
        return bookOrderDto;
    }

    @Override
    public void delete(Integer id) {
        bookOrderRepository.deleteById(id);
    }

    @Override
    public BookOrderDto postOrder(BookOrderDto bookOrderDto) {
        Customer customer = customerRepository.findById(bookOrderDto.getCustomerDto().getId()).orElseThrow(() -> new EntityNotFoundException("Could not find specified customer"));
        bookOrderDto.setCustomerDto(customerEntityToDto(customer));
        BookOrder bookOrder = dtoToEntity(bookOrderDto);
        BookOrder bookOrderSaved = bookOrderRepository.save(bookOrder);
        BookOrderDto bookOrderDtoSaved = entityToDto(bookOrderSaved);
        return bookOrderDtoSaved;
    }

    @Override
    public BookOrderDto updateOrder(BookOrderDto bookOrderDto, Integer id) {
        BookOrder updatedBookOrder = dtoToEntity(bookOrderDto);
        BookOrder bookOrderFromDB = bookOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book order with specified id=" + id));
        bookOrderFromDB.setOrderDate(updatedBookOrder.getOrderDate());
        bookOrderFromDB.setOrderPrice(updatedBookOrder.getOrderPrice());
        bookOrderFromDB.setOrderStatus(updatedBookOrder.getOrderStatus());
        bookOrderFromDB.setCustomer(updatedBookOrder.getCustomer());
        BookOrder bookOrderSaved = bookOrderRepository.save(bookOrderFromDB);
        BookOrderDto bookOrderDto1 = entityToDto(bookOrderSaved);
        return bookOrderDto1;
    }

    private BookOrderDto entityToDto(BookOrder bookOrder) {
        BookOrderDto bookOrderDto = new BookOrderDto();
        bookOrderDto.setId(bookOrder.getId());
        bookOrderDto.setOrderDate(bookOrder.getOrderDate());
        bookOrderDto.setOrderPrice(bookOrder.getOrderPrice());
        bookOrderDto.setOrderStatus(bookOrder.getOrderStatus());
        bookOrderDto.setCustomerDto(customerEntityToDto(bookOrder.getCustomer()));
        return bookOrderDto;
    }

    private BookOrder dtoToEntity(BookOrderDto bookOrderDto) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setId(bookOrderDto.getId());
        bookOrder.setOrderDate(bookOrderDto.getOrderDate());
        bookOrder.setOrderStatus(bookOrderDto.getOrderStatus());
        bookOrder.setOrderPrice(bookOrderDto.getOrderPrice());
        bookOrder.setCustomer(customerDtoToEntity(bookOrderDto.getCustomerDto()));
        return bookOrder;
    }

    private CustomerDto customerEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setCustomerSurname(customer.getCustomerSurname());
        customerDto.setCustomerGender(customer.getCustomerGender());
        customerDto.setCustomerPhoneNum(customer.getCustomerPhoneNum());
        customerDto.setCustomerEmail(customer.getCustomerEmail());
        customerDto.setCustomerCountry(customer.getCustomerCountry());
        customerDto.setCustomerCity(customer.getCustomerCity());
        customerDto.setCustomerStreet(customer.getCustomerStreet());
        customerDto.setCustomerPassword(customer.getCustomerPassword());
        return customerDto;
    }

    private Customer customerDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerSurname(customerDto.getCustomerSurname());
        customer.setCustomerGender(customerDto.getCustomerGender());
        customer.setCustomerPhoneNum(customerDto.getCustomerPhoneNum());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerCountry(customerDto.getCustomerCountry());
        customer.setCustomerCity(customerDto.getCustomerCity());
        customer.setCustomerStreet(customerDto.getCustomerStreet());
        customer.setCustomerPassword(customerDto.getCustomerPassword());
        return customer;
    }
}
