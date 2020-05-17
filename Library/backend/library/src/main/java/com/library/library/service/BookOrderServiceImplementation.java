package com.library.library.service;

import com.library.library.model.BookOrder;
import com.library.library.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class BookOrderServiceImplementation implements BookOrderService {
    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Override
    public Collection<BookOrder> getAllOrders() {
        return bookOrderRepository.findAll();
    }

    @Override
    public BookOrder getOrderById(Integer id) {
        return bookOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book order with specified id="+id));
    }

    @Override
    public void delete(Integer id) {
        bookOrderRepository.deleteById(id);
    }

    @Override
    public BookOrder postOrder(BookOrder bookOrder) {
        return bookOrderRepository.save(bookOrder);
    }

    @Override
    public BookOrder updateOrder(BookOrder bookOrder, Integer id) {
        BookOrder bookOrderFromDB = getOrderById(id);
        bookOrderFromDB.setOrderDate(bookOrder.getOrderDate());
        bookOrderFromDB.setOrderPrice(bookOrder.getOrderPrice());
        bookOrderFromDB.setOrderStatus(bookOrder.getOrderStatus());
        bookOrderFromDB.setCustomer(bookOrder.getCustomer());
        return bookOrderRepository.save(bookOrderFromDB);
    }
}
