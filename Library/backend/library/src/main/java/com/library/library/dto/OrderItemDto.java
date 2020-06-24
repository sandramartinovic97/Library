package com.library.library.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class OrderItemDto {
    private Integer id;
    private BookOrderDto bookOrderDto;
    private BookDto bookDto;
    private Double itemPrice;
    private Integer itemQuantity;
    private Integer customerId;
}
