package com.library.library.service;

import com.library.library.dto.BookDto;

import java.util.Collection;

public interface BookService {
    public Collection<BookDto> getAllBooks();

    public BookDto getBookById(Integer id);

    public BookDto postBook(BookDto bookDto);

    public void deleteBook(Integer id);

    public BookDto updateBook(BookDto bookDto, Integer id);
}
