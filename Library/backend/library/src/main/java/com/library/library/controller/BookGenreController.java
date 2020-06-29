package com.library.library.controller;

import com.library.library.dto.BookDto;
import com.library.library.dto.BookGenreDto;
import com.library.library.dto.GenreDto;
import com.library.library.model.Genre;
import com.library.library.service.BookGenreService;

import com.library.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookGenre")
@CrossOrigin(origins = "http://localhost:4200")
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
    public void deleteBookGenre(@PathVariable("id") Integer id) {
        bookGenreService.deleteBookGenre(id);
    }

    @PostMapping
    public void postBookGenre(@RequestBody BookGenreDto bookGenreDto) {
        bookGenreService.postBookGenre(bookGenreDto);
    }

    @PutMapping("/{id}")
    public void updateBookGenre(@RequestBody BookGenreDto bookGenreDto, @PathVariable("id") Integer id) {
        bookGenreService.updateBookGenre(bookGenreDto, id);
    }

    @GetMapping("/getByGenre")
    public Collection<BookDto> getBookByGenreId(@RequestParam(name = "genreId") Integer genreId) {
        return bookGenreService.getBooksByGenre(genreId);
    }
}
