package com.library.library.service;

import com.library.library.model.Genre;

import java.util.List;

public interface GenreService {
    public List<Genre> getGenres();
    public Genre getGenreById(Integer id);
    void deleteGenre(Integer id);
}
