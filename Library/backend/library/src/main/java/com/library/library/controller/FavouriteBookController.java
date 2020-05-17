package com.library.library.controller;

import com.library.library.model.Customer;
import com.library.library.model.FavouriteBook;
import com.library.library.service.FavouriteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public FavouriteBook getFavouriteBook(@PathVariable("id") Integer id){
        return favouriteBookService.getFavouriteBook(id);

    }
    @DeleteMapping("favouritebook/{id}")
    public ResponseEntity<FavouriteBook> deleteFavouriteBook(@PathVariable ("id") Integer id){
        if(!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.deleteFavouriteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("favouritebook")
    public ResponseEntity<FavouriteBook> insertFavouriteBook(@RequestBody FavouriteBook favouritebook){
        if(!favouriteBookService.existsById(favouritebook.getId())){
            favouriteBookService.postFavouriteBook(favouritebook);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @PutMapping("favouritebook")
    public ResponseEntity<FavouriteBook> updateFavouriteBook(@RequestBody FavouriteBook favouritebook) {
        if (!favouriteBookService.existsById(favouritebook.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.updateFavouriteBook(favouritebook);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
