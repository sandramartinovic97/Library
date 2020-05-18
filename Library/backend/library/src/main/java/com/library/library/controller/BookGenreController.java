package com.library.library.controller;

import com.library.library.model.BookGenre;
import com.library.library.service.BookGenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookGenre")
public class BookGenreController {

    @Autowired
    private BookGenreService bookGenreService;

    @GetMapping
    public Collection<BookGenre> getAllBookGenres() {
        return bookGenreService.getAllBookGenre();
    }

    @GetMapping("/{id}")
    public BookGenre getBookGenreById(@PathVariable("id") Integer id) {
        return bookGenreService.getBookGenreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookGenre(@PathVariable("id") Integer id) {
            bookGenreService.deleteBookGenre(id);
    }

    @PostMapping
    public BookGenre postBookGenre(@RequestBody BookGenre bookGenre){
           return bookGenreService.postBookGenre(bookGenre);
    }

    @PutMapping("/{id}")
    public BookGenre updateBookGenre(@RequestBody BookGenre bookGenre, @PathVariable("id") Integer id){
            return bookGenreService.updateBookGenre(bookGenre,id);
    }
}
