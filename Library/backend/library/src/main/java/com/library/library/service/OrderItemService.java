package com.library.library.service;

import com.library.library.model.OrderItem;

import java.util.Collection;

public interface OrderItemService {
    public Collection<OrderItem> getAllItems();

    public OrderItem getItemById(Integer id);

    public OrderItem postItem(OrderItem orderItem);

    public void deleteItem(Integer id);

    public OrderItem updateItem(OrderItem orderItem, Integer id);
}
