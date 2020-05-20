package com.library.library.dto;


import lombok.Data;

@Data
public class BookGenreDto {

    private Integer id;

    private BookDto bookDto;

    private GenreDto genreDto;
}
