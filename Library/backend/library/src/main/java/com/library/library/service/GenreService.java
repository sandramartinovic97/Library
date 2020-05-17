package com.library.library.service;

import com.library.library.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();
    Genre getGenreById(Integer id);
    Genre createGenre(Genre genre);
    void deleteGenre(Integer id);
}
