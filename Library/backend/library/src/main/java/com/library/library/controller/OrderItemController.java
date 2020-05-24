package com.library.library.controller;

import com.library.library.dto.OrderItemDto;
import com.library.library.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public Collection<OrderItemDto> getAllItems() {
        return orderItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public OrderItemDto getItemById(@PathVariable("id") Integer id) {
        return orderItemService.getItemById(id);
    }

    @PostMapping
    public void postItem(@RequestBody OrderItemDto orderItemDto) {
        orderItemService.postItem(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Integer id) {
        orderItemService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public OrderItemDto updateItem(@PathVariable("id") Integer id, @RequestBody OrderItemDto orderItemDto) {
        return orderItemService.updateItem(orderItemDto, id);
    }
}
