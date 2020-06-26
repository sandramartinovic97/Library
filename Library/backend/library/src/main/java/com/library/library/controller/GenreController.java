package com.library.library.controller;

import com.library.library.dto.GenreDto;
import com.library.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<GenreDto> getGenres() {
        return genreService.getGenres();
    }

    @GetMapping("/{id}")
    public GenreDto getGenreById(@PathVariable("id") Integer id) {
        return genreService.getGenreById(id);
    }

    @PostMapping
    public void createGenre(@RequestBody GenreDto genreDto) {
        genreService.createGenre(genreDto);
    }

    @PutMapping("/{id}")
    public void updateGenre(@PathVariable("id") Integer id, @RequestBody GenreDto genreDto) {
        genreService.updateGenre(id, genreDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Integer id) {
        genreService.deleteGenre(id);
    }
}