package com.library.library.service;


import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.library.library.model.Book;

import javax.persistence.EntityNotFoundException;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book with id=" + id));
    }

    @Override
    public boolean existsBookById(Integer id) { return bookRepository.existsById(id); }

    @Override
    public void postBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {

        //   treba dodati
        //   jdbcTemplate.execute("delete from Favourite_Book where book_id = "+id);
        //   jdbcTemplate.execute("delete from Book_Order where book_id = "+id); -- iz tabele bookGenre
        // jdbcTemplate.execute("delete from Favourite_Book where book_id = "+id); --iz tabele item
        bookRepository.deleteById(id);
    }

    @Override
    public void putBook(Book book) {
        bookRepository.save(book);
    }
}
