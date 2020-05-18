package com.library.library.controller;

import com.library.library.model.OrderItem;
import com.library.library.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public Collection<OrderItem> getAllItems() {
        return orderItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public OrderItem getItemById(@PathVariable("id") Integer id) {
        return orderItemService.getItemById(id);
    }

    @PostMapping
    public void postItem(@RequestBody OrderItem orderItem) {
        orderItemService.postItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        orderItemService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public OrderItem updateItem(@PathVariable("id") Integer id, @RequestBody OrderItem orderItem) {
        return orderItemService.updateItem(orderItem, id);
    }
}
