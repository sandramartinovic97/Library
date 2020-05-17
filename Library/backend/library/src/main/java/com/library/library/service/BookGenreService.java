package com.library.library.service;

import com.library.library.model.BookGenre;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface BookGenreService {

    public Collection<BookGenre> getAllBookGenre();

    public BookGenre getBookGenreById(Integer id);

    public boolean existsBookGenreById(Integer id);

    public void postBookGenre(BookGenre book);

    public void deleteBookGenre(Integer id);

    public void putBookGenre(BookGenre bookGenre);
}
