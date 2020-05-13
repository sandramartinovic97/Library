package com.library.library.service;

import com.library.library.model.BookOrder;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface BookOrderService {
    public Collection<BookOrder> getAllOrders();
}
