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
    public Book postBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        jdbcTemplate.execute("delete from FAVOURITE_BOOK where book_id = "+id);
        jdbcTemplate.execute("delete from BOOK_GENRE where book_id = "+id);
        jdbcTemplate.execute("delete from ORDER_ITEM where book_id = "+id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Book book, Integer id) {
        Book bookFromDB=getBookById(id);
        bookFromDB.setBookAuthor(book.getBookAuthor());
        bookFromDB.setBookDescription(book.getBookDescription());
        bookFromDB.setBookLanguage(book.getBookLanguage());
        bookFromDB.setBookName(book.getBookName());
        bookFromDB.setBookPrice(book.getBookPrice());
        bookFromDB.setBookPublisher(book.getBookPublisher());
        bookFromDB.setBookQuantity(book.getBookQuantity());
        bookFromDB.setBookYear(book.getBookYear());
        return bookRepository.save(book);
    }
}
