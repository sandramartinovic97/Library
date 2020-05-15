package com.library.library.controller;

import com.library.library.service.FavouriteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavouriteBookController {

    @Autowired
    private FavouriteBookService favouriteBookService;

}
