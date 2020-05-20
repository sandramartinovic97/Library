package com.library.library.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookOrderDto {
    private Integer id;
    private Date orderDate;
    private String orderStatus;
    private Double orderPrice;
    private CustomerDto customerDto;
}
