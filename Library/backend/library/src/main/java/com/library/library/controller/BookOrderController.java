package com.library.library.controller;

import com.library.library.model.BookOrder;
import com.library.library.repository.BookOrderRepository;
import com.library.library.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookOrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @GetMapping("orders")
    public Collection<BookOrder> getAllOrders() {
        return bookOrderService.getAllOrders();
    }
}

