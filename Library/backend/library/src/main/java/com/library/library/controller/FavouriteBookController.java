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
@RequestMapping("/favouritebook")
public class FavouriteBookController {

    @Autowired
    private FavouriteBookService favouriteBookService;

    @GetMapping
    public Collection<FavouriteBook> getAllFavouriteBooks(){
        return favouriteBookService.getAllFavouriteBooks();
    }

    @GetMapping("/{id}")
    public FavouriteBook getFavouriteBook(@PathVariable("id") Integer id){
        return favouriteBookService.getFavouriteBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FavouriteBook> deleteFavouriteBook(@PathVariable ("id") Integer id){
        if(!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.deleteFavouriteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public FavouriteBook insertFavouriteBook(@RequestBody FavouriteBook favouritebook){
       return favouriteBookService.insertFavouriteBook(favouritebook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FavouriteBook> updateFavouriteBook(@RequestBody FavouriteBook favouritebook,@PathVariable ("id") Integer id) {
        if (!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.updateFavouriteBook(favouritebook,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
