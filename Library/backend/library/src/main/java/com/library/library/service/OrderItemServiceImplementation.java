package com.library.library.service;

import com.library.library.model.OrderItem;
import com.library.library.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class OrderItemServiceImplementation implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Collection<OrderItem> getAllItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getItemById(Integer id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order item with specified id=" + id));
    }

    @Override
    public OrderItem postItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteItem(Integer id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public OrderItem updateItem(OrderItem orderItem, Integer id) {
        OrderItem orderItemFromDB = getItemById(id);
        orderItemFromDB.setOrder(orderItem.getOrder());
        orderItemFromDB.setBook(orderItem.getBook());
        orderItemFromDB.setItemPrice(orderItem.getItemPrice());
        orderItemFromDB.setItemQuantity(orderItem.getItemQuantity());
        return orderItemRepository.save(orderItemFromDB);
    }
}
