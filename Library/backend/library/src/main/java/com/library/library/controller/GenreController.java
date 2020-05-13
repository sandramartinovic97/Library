package com.library.library.controller;

import com.library.library.model.Genre;
import com.library.library.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getGenres() {
        List<Genre> genre = genreService.getGenres();

        return ResponseEntity.ok(genre);
    }
}
