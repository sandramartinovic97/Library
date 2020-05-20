package com.library.library.service;

import com.library.library.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getGenres();
    GenreDto getGenreById(Integer id);
    GenreDto createGenre(GenreDto genreDto);
    GenreDto updateGenre(Integer id, GenreDto genreDto);
    void deleteGenre(Integer id);
}
