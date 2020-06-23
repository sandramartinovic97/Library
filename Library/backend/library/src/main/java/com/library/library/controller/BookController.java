package com.library.library.controller;

import com.library.library.dto.BookDto;
import com.library.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.OPTIONS })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Collection<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) {

        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("The book is deleted.");
    }

    @PostMapping
    public ResponseEntity<String> postBook(@RequestBody BookDto bookDto){
        bookService.postBook(bookDto);
        return ResponseEntity.status(HttpStatus.OK).body("New book is created.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putBook(@RequestBody BookDto bookDto, @PathVariable("id") Integer id){
        bookService.updateBook(bookDto,id);
        return ResponseEntity.status(HttpStatus.OK).body("The book is updated.");
    }
}
