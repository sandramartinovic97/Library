package com.library.library.service;

import com.library.library.dto.GenreDto;
import com.library.library.model.Genre;
import com.library.library.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImplementation implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<GenreDto> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genreDtos = new ArrayList<>();
        for (Genre genre : genres) {
            GenreDto genreDto = modelMapper.map(genre, GenreDto.class);
            genreDtos.add(genreDto);
        }
        return genreDtos;
    }

    @Override
    public GenreDto getGenreById(Integer id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find genre with id=" + id));

        return modelMapper.map(genre, GenreDto.class);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = modelMapper.map(genreDto, Genre.class);
        genreRepository.save(genre);

        return modelMapper.map(genre, GenreDto.class);
    }

    @Override
    public GenreDto updateGenre(Integer id, GenreDto genreDto) {
        Genre updatedGenre = modelMapper.map(genreDto, Genre.class);
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find genre with id=" + id));
        genre.setGenreName(updatedGenre.getGenreName());
        genreRepository.save(genre);

        return modelMapper.map(genre, GenreDto.class);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}