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
    public BookGenre getBookGenresById(@PathVariable("id") Integer id) {
        return bookGenreService.getBookGenreById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookGenre> deleteBookGenre(@PathVariable("id") Integer id) {

        if(bookGenreService.existsBookGenreById(id)){
            bookGenreService.deleteBookGenre(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<BookGenre> postBookGenre(@RequestBody BookGenre bookGenre){
        if(!bookGenreService.existsBookGenreById(bookGenre.getId())){
            bookGenreService.postBookGenre(bookGenre);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookGenre> putBook(@RequestBody BookGenre bookGenre){
        if(bookGenreService.existsBookGenreById(bookGenre.getId())){
            bookGenreService.putBookGenre(bookGenre);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
