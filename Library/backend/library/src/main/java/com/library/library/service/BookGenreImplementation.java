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
        return bookGenreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book genre with id=" + id));
    }


    @Override
    public BookGenre postBookGenre(BookGenre bookGenre) {
        return bookGenreRepository.save(bookGenre);
    }

    @Override
    public void deleteBookGenre(Integer id) {
        bookGenreRepository.deleteById(id);
    }

    @Override
    public BookGenre updateBookGenre(BookGenre bookGenre, Integer id) {
        BookGenre bookGenreFromDB = getBookGenreById(id);
        bookGenreFromDB.setGenre(bookGenre.getGenre());
        bookGenreFromDB.setBook(bookGenre.getBook());
        return bookGenreRepository.save(bookGenreFromDB);

    }
}
