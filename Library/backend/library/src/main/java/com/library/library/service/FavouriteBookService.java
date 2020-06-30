package com.library.library.service;

import com.library.library.dto.FavouriteBookDto;

import java.util.Collection;

public interface FavouriteBookService {
    public Collection<FavouriteBookDto> getAllFavouriteBooks();
    public FavouriteBookDto getFavouriteBook(Integer id);
    public boolean existsById(Integer id);
    public void deleteFavouriteBookById(Integer id);
    public FavouriteBookDto updateFavouriteBook(FavouriteBookDto favouritebook,Integer id);
    public FavouriteBookDto insertFavouriteBook(FavouriteBookDto favouritebook);
    public Collection<FavouriteBookDto> getFavouriteByCustomerId(Integer customerId);
    public FavouriteBookDto getFavouriteByCustomerIdAndBookId(Integer customerId, Integer bookId);
}