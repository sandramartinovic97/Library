package com.library.library.service;

import com.library.library.dto.GenreDto;
import com.library.library.model.Genre;
import com.library.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImplementation implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreDto> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genreDtos = new ArrayList<>();
        for (Genre genre : genres) {
            genreDtos.add(entityToDto(genre));
        }
        return genreDtos;
    }

    @Override
    public GenreDto getGenreById(Integer id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find genre with id=" + id));
        GenreDto genreDto = entityToDto(genre);

        return genreDto;
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = dtoToEntity(genreDto);
        Genre newGenre = genreRepository.save(genre);
        GenreDto newGenreDto = entityToDto(newGenre);

        return newGenreDto;
    }

    @Override
    public GenreDto updateGenre(Integer id, GenreDto genreDto) {
        Genre updatedGenre = dtoToEntity(genreDto);
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find genre with id=" + id));
        genre.setGenreName(updatedGenre.getGenreName());
        Genre genreSaved = genreRepository.save(genre);
        GenreDto newGenreDto = entityToDto(genreSaved);

        return newGenreDto;
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }

    private GenreDto entityToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setGenreName(genre.getGenreName());

        return genreDto;
    }

    private Genre dtoToEntity(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setGenreName(genreDto.getGenreName());

        return genre;
    }
}