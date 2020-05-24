package com.library.library.controller;

import com.library.library.dto.BookOrderDto;
import com.library.library.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class BookOrderController {
    @Autowired
    private BookOrderService bookOrderService;

    @GetMapping
    public Collection<BookOrderDto> getAllOrders() {
        return bookOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public BookOrderDto getOrderById(@PathVariable("id") Integer id) {
        return bookOrderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookOrder(@PathVariable("id") Integer id) {
        bookOrderService.delete(id);
    }

    @PostMapping()
    public void postOrder(@RequestBody BookOrderDto orderDto) {
        bookOrderService.postOrder(orderDto);
    }

    @PutMapping("/{id}")
    public BookOrderDto updateOrder(@RequestBody BookOrderDto bookOrderDto, @PathVariable("id") Integer id) {
        return bookOrderService.updateOrder(bookOrderDto, id);
    }
}

