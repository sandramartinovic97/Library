package com.library.library.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Integer id;
    private BookOrderDto bookOrderDto;
    private BookDto bookDto;
    private Double itemPrice;
    private Integer itemQuantity;
}
