package com.library.library.service;

import com.library.library.model.Genre;
import com.library.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GenreServiceImplementation implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find genre with id=" + id));
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Integer id, Genre genre) {
        Genre genreDB = getGenreById(id);
        genreDB.setGenreName(genre.getGenreName());
        return genreRepository.save(genreDB);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}