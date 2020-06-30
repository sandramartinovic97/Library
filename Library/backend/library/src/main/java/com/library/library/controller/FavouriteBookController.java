package com.library.library.controller;

import com.library.library.dto.FavouriteBookDto;
import com.library.library.service.FavouriteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/favouritebook")
@CrossOrigin(origins = "http://localhost:4200")
public class FavouriteBookController {

    @Autowired
    private FavouriteBookService favouriteBookService;

    @GetMapping
    public Collection<FavouriteBookDto> getAllFavouriteBooks(){
        return favouriteBookService.getAllFavouriteBooks();
    }

    @GetMapping("/{id}")
    public FavouriteBookDto getFavouriteBook(@PathVariable("id") Integer id){
        return favouriteBookService.getFavouriteBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FavouriteBookDto> deleteFavouriteBook(@PathVariable ("id") Integer id){
        if(!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.deleteFavouriteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public FavouriteBookDto insertFavouriteBook(@RequestBody FavouriteBookDto favouritebook){
       return favouriteBookService.insertFavouriteBook(favouritebook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FavouriteBookDto> updateFavouriteBook(@RequestBody FavouriteBookDto favouritebook,@PathVariable ("id") Integer id) {
        if (!favouriteBookService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        favouriteBookService.updateFavouriteBook(favouritebook,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getFavouriteByCustomer")
    public Collection<FavouriteBookDto> getFavouriteByCustomerId(@RequestParam("customerId") Integer customerId) {
        return favouriteBookService.getFavouriteByCustomerId(customerId);
    }

    @GetMapping("/getFavouriteByCustomerAndBook")
    public FavouriteBookDto getFavouriteByCustomerIdAndBookId(@RequestParam(name="customerId") Integer customerId, @RequestParam(name="bookId") Integer bookId) {
        return favouriteBookService.getFavouriteByCustomerIdAndBookId(customerId, bookId);
    }


}