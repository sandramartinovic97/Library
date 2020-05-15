package com.library.library.service;

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
    public FavouriteBook getFavouriteBook(Integer id) {
        return favouriteBookRepository.getFavouriteBookById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return favouriteBookRepository.existsById(id);
    }

    @Override
    public void deleteFavouriteBookById(Integer id) {
        favouriteBookRepository.deleteById(id);
    }

    @Override
    public void postFavouriteBook(FavouriteBook favouritebook) {
        favouriteBookRepository.save(favouritebook);
    }

    @Override
    public void updateFavouriteBook(FavouriteBook favouritebook) {
        favouriteBookRepository.save(favouritebook);
    }
}
