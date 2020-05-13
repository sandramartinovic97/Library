package com.library.library.service;

import com.library.library.model.Genre;
import com.library.library.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreImpl implements GenreService {
    private  GenreService genreService;
    private GenreRepository genreRepository;

    public List<Genre> getGenres() {
        List<Genre> genres = genreRepository.findAll();

        return genres;
    }
}
