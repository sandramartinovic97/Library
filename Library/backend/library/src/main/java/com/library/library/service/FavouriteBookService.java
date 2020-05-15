package com.library.library.service;

import com.library.library.model.Customer;
import com.library.library.model.FavouriteBook;

import java.util.Collection;

public interface FavouriteBookService {
    public Collection<FavouriteBook> getAllFavouriteBooks();

    public Customer getFavouriteBook(Integer id);
}
