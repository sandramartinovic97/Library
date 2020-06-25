package com.library.library.service;

import com.library.library.dto.OrderItemDto;

import java.util.Collection;

public interface OrderItemService {
    public Collection<OrderItemDto> getAllItems();

    public OrderItemDto getItemById(Integer id);

    public Collection<OrderItemDto> getItemByCustomerId(Integer customerId);

    public OrderItemDto postItem(OrderItemDto orderItemDto);

    public void deleteItem(Integer id);

    public OrderItemDto updateItem(OrderItemDto orderItemDto, Integer id);
}
