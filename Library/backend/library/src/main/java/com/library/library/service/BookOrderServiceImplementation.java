package com.library.library.service;

import com.library.library.model.BookOrder;
import com.library.library.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookOrderServiceImplementation implements BookOrderService {
    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Override
    public Collection<BookOrder> getAllOrders() {
        return bookOrderRepository.findAll();
    }
}
