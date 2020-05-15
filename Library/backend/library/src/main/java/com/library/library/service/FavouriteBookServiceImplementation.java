package com.library.library.service;

import com.library.library.model.Customer;
import com.library.library.model.FavouriteBook;
import com.library.library.repository.FavouriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FavouriteBookServiceImplementation implements FavouriteBookService {
    @Autowired
    private FavouriteBookRepository favouriteBookRepository;

    @Override
    public Collection<FavouriteBook> getAllFavouriteBooks() {
        return favouriteBookRepository.findAll();
    }

    @Override
    public Customer getFavouriteBook(Integer id) {
        return favouriteBookRepository.getFavouriteBookById(id);
    }
}
