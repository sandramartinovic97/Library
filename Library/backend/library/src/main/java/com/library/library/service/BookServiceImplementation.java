package com.library.library.service;


import com.library.library.dto.BookDto;
import com.library.library.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import com.library.library.model.Book;

import javax.persistence.EntityNotFoundException;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public Collection<BookDto> getAllBooks() {

        Collection<Book> books = bookRepository.findAll();
        Collection<BookDto> booksDto = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = modelMapper.map(book, BookDto.class);
            booksDto.add(bookDto);
        }
        return booksDto;
    }

    @Override
    public BookDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book with id=" + id));
        return modelMapper.map(book, BookDto.class);
    }


    @Override
    public BookDto postBook(BookDto bookDto) {
       Book book = modelMapper.map(bookDto, Book.class);
       bookRepository.save(book);
       return modelMapper.map(book, BookDto.class);

    }

    @Override
    public void deleteBook(Integer id) {
        jdbcTemplate.execute("delete from FAVOURITE_BOOK where book_id = "+id);
        jdbcTemplate.execute("delete from BOOK_GENRE where book_id = "+id);
        jdbcTemplate.execute("delete from ORDER_ITEM where book_id = "+id);
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Integer id) {
        Book updatedBook = modelMapper.map(bookDto, Book.class);
        Book bookFromDB=bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book with specified id=" + id));
        bookFromDB.setBookAuthor(updatedBook.getBookAuthor());
        bookFromDB.setBookDescription(updatedBook.getBookDescription());
        bookFromDB.setBookLanguage(updatedBook.getBookLanguage());
        bookFromDB.setBookName(updatedBook.getBookName());
        bookFromDB.setBookPrice(updatedBook.getBookPrice());
        bookFromDB.setBookPublisher(updatedBook.getBookPublisher());
        bookFromDB.setBookQuantity(updatedBook.getBookQuantity());
        bookFromDB.setBookYear(updatedBook.getBookYear());
        return modelMapper.map(bookRepository.save(bookFromDB), BookDto.class);
    }

    /*private BookDto entityToDto(Book book) {

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setBookName(book.getBookName());
        bookDto.setBookDescription(book.getBookDescription());
        bookDto.setBookLanguage(book.getBookLanguage());
        bookDto.setBookPrice(book.getBookPrice());
        bookDto.setBookPublisher(book.getBookPublisher());
        bookDto.setBookQuantity(book.getBookQuantity());
        bookDto.setBookYear(book.getBookYear());

        return bookDto;
    }

    private Book dtoToEntity(BookDto bookDto) {
        
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookAuthor(bookDto.getBookAuthor());
        book.setBookDescription(bookDto.getBookDescription());
        book.setBookLanguage(bookDto.getBookLanguage());
        book.setBookName(bookDto.getBookName());
        book.setBookPrice(bookDto.getBookPrice());
        book.setBookPublisher(bookDto.getBookPublisher());
        book.setBookQuantity(bookDto.getBookQuantity());
        book.setBookYear(bookDto.getBookYear());
        return book;
    }*/
}
