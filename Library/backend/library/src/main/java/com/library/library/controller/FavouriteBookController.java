package com.library.library.controller;

import com.library.library.model.Customer;
import com.library.library.model.FavouriteBook;
import com.library.library.service.FavouriteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class FavouriteBookController {

    @Autowired
    private FavouriteBookService favouriteBookService;

    @GetMapping("favouritebook")
    public Collection<FavouriteBook> getAllFavouriteBooks(){
        return favouriteBookService.getAllFavouriteBooks();
    }

    @GetMapping("favouritebook/{id}")
    public Customer getFavouriteBook(@PathVariable("id") Integer id){
        return favouriteBookService.getFavouriteBook(id);

    }
    @DeleteMapping("favouritebook/{id}")
    public ResponseEntity<FavouriteBook> deleteFavouriteBook(@PathVariable ("id") Integer id){
        if(!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.deleteFavouriteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
