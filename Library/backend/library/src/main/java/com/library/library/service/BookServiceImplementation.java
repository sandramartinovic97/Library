package com.library.library.service;


import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.library.library.model.Book;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
