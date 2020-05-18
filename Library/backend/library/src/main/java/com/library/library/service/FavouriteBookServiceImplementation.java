package com.library.library.service;

import com.library.library.model.FavouriteBook;
import com.library.library.repository.FavouriteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return favouriteBookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find favourite book with specified id="+id));
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
    public FavouriteBook updateFavouriteBook(FavouriteBook favouritebook, Integer id) {
        FavouriteBook favouriteBookFromDB = getFavouriteBook(id);
        favouriteBookFromDB.setBook(favouritebook.getBook());
        favouriteBookFromDB.setCustomer(favouritebook.getCustomer());

        return favouriteBookRepository.save(favouriteBookFromDB);
    }

    @Override
    public FavouriteBook insertFavouriteBook(FavouriteBook favouritebook) {
        return favouriteBookRepository.save(favouritebook);
    }

}
