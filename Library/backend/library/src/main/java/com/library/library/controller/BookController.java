package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {

        if(bookService.existsBookById(id)){
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        if(!bookService.existsBookById(book.getId())){
            bookService.postBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> putBook(@RequestBody Book book){
        if(bookService.existsBookById(book.getId())){
            bookService.putBook(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
