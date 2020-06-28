package com.library.library.repository;

import com.library.library.dto.GenreDto;
import com.library.library.model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {
    Optional<Collection<BookGenre>> findByGenre(GenreDto genreDto);
}
