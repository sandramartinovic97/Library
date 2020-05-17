package com.library.library.repository;

import com.library.library.model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {
}
