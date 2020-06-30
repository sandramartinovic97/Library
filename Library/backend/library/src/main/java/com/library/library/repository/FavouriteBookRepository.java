
package com.library.library.repository;

import com.library.library.model.FavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface FavouriteBookRepository extends JpaRepository<FavouriteBook, Integer> {
    Collection<FavouriteBook> findByCustomerId(Integer customerId);
    Optional<FavouriteBook> findByCustomerIdAndBookId(Integer customerId, Integer bookId);
}