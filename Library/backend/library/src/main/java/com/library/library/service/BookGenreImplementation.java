package com.library.library.service;

import com.library.library.model.BookGenre;
import com.library.library.repository.BookGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class BookGenreImplementation implements BookGenreService{

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Override
    public Collection<BookGenre> getAllBookGenre() {
        return bookGenreRepository.findAll();
    }

    @Override
    public BookGenre getBookGenreById(Integer id) {
        return bookGenreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book with id=" + id));
    }

    @Override
    public boolean existsBookGenreById(Integer id) {
        return bookGenreRepository.existsById(id);
    }

    @Override
    public void postBookGenre(BookGenre bookGenre) {
        BookGenre newBookGenre= new BookGenre();
        newBookGenre.setBookId(bookGenre.getBookId());
        newBookGenre.setGenreId(bookGenre.getGenreId());
        bookGenreRepository.save(newBookGenre);
    }

    @Override
    public void deleteBookGenre(Integer id) {
        bookGenreRepository.deleteById(id);
    }

    @Override
    public void putBookGenre(BookGenre bookGenre) {
        bookGenreRepository.save(bookGenre);
    }
}
