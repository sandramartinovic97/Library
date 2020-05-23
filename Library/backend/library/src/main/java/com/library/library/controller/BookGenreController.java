package com.library.library.controller;

import com.library.library.dto.BookGenreDto;
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
    public Collection<BookGenreDto> getAllBookGenres() {
        return bookGenreService.getAllBookGenre();
    }

    @GetMapping("/{id}")
    public BookGenreDto getBookGenreById(@PathVariable("id") Integer id) {
        return bookGenreService.getBookGenreById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookGenre(@PathVariable("id") Integer id){
        bookGenreService.deleteBookGenre(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book genre with id=" + id + " is deleted.");
    }

    @PostMapping
    public ResponseEntity<String> postBookGenre(@RequestBody BookGenreDto bookGenreDto){
        bookGenreService.postBookGenre(bookGenreDto);
        return ResponseEntity.status(HttpStatus.OK).body("New book genre is created.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookGenre(@RequestBody BookGenreDto bookGenreDto, @PathVariable("id") Integer id){
         bookGenreService.updateBookGenre(bookGenreDto,id);
         return ResponseEntity.status(HttpStatus.OK).body("The book genre is updated.");
    }
}
