package com.library.library.dto;

import lombok.Data;

@Data
public class FavouriteBookDto {
    // private Integer id;
    private BookDto bookDto;
    private CustomerDto customerDto;
}
