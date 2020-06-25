package com.library.library.repository;

import com.library.library.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    Collection<OrderItem> findByCustomerId(Integer customerId);
}
