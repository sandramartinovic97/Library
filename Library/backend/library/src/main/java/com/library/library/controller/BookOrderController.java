package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.model.BookOrder;
import com.library.library.repository.BookOrderRepository;
import com.library.library.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class BookOrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @GetMapping
    public Collection<BookOrder> getAllOrders() {
        return bookOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public BookOrder getOrderById(@PathVariable("id") Integer id) {
        return bookOrderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookOrder(@PathVariable("id") Integer id) {
        bookOrderService.delete(id);
    }

    @PostMapping()
    public void postOrder(@RequestBody BookOrder order) {
        bookOrderService.postOrder(order);
    }

    @PutMapping("/{id}")
    public BookOrder updateOrder(@RequestBody BookOrder bookOrder, @PathVariable("id") Integer id) {
        return bookOrderService.updateOrder(bookOrder, id);
    }
}

