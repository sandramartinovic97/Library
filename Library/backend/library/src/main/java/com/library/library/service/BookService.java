package com.library.library.service;

import com.library.library.model.Book;

import java.util.Collection;

public interface BookService {
    public Collection<Book> getAllBooks();

    public Book getBookById(Integer id);

    public boolean existsBookById(Integer id);

    public void postBook(Book book);

    public void deleteBook(Integer id);

    public void putBook(Book book);
}
