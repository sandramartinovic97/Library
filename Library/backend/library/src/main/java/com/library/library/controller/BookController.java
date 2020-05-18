package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/books")
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
    public void deleteBook(@PathVariable("id") Integer id) {
            bookService.deleteBook(id);
    }

    @PostMapping
    public Book postBook(@RequestBody Book book){
           return  bookService.postBook(book);
    }

    @PutMapping("/{id}")
    public Book putBook(@RequestBody Book book, @PathVariable("id") Integer id){
        return bookService.updateBook(book,id);
    }
}
