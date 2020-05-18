package com.library.library.service;

import com.library.library.model.BookGenre;

import java.util.Collection;

public interface BookGenreService {

    public Collection<BookGenre> getAllBookGenre();

    public BookGenre getBookGenreById(Integer id);

    public BookGenre postBookGenre(BookGenre book);

    public void deleteBookGenre(Integer id);

    public BookGenre updateBookGenre(BookGenre bookGenre, Integer id);
}
