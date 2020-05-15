package com.library.library.service;

import com.library.library.repository.FavouriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteBookServiceImplementation implements FavouriteBookService {
    @Autowired
    private FavouriteBookRepository favouriteBookRepository;
}
