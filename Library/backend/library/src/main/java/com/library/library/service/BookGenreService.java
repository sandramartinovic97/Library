package com.library.library.service;

import com.library.library.dto.BookGenreDto;

import java.util.Collection;

public interface BookGenreService {

    public Collection<BookGenreDto> getAllBookGenre();

    public BookGenreDto getBookGenreById(Integer id);

    public BookGenreDto postBookGenre(BookGenreDto bookGenreDto);

    public void deleteBookGenre(Integer id);

    public BookGenreDto updateBookGenre(BookGenreDto bookGenreDto, Integer id);
}
