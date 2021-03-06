package com.library.library.service;

import com.library.library.dto.*;
import com.library.library.model.Book;
import com.library.library.model.BookGenre;
import com.library.library.model.FavouriteBook;
import com.library.library.model.OrderItem;
import com.library.library.repository.FavouriteBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class FavouriteBookServiceImplementation implements FavouriteBookService {
    @Autowired
    private FavouriteBookRepository favouriteBookRepository;

    private ModelMapper modelMapper=new ModelMapper();


    @Override
    public Collection<FavouriteBookDto> getAllFavouriteBooks() {

        Collection<FavouriteBook> favouriteBooks = favouriteBookRepository.findAll();
        Collection<FavouriteBookDto> favouriteBookDtos = new ArrayList<>();
        for(FavouriteBook favbook : favouriteBooks){
            FavouriteBookDto favouriteBookDto = modelMapper.map(favbook, FavouriteBookDto.class);
            favouriteBookDto.setBookDto(modelMapper.map(favbook.getBook(), BookDto.class));
            favouriteBookDto.setCustomerDto(modelMapper.map(favbook.getCustomer(), CustomerDto.class));
            favouriteBookDtos.add(favouriteBookDto);
        }
        return favouriteBookDtos;
    }

    @Override
    public FavouriteBookDto getFavouriteBook(Integer id) {

        FavouriteBook favouriteBook = favouriteBookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find favourite book with specified id="+id));
        FavouriteBookDto favouriteBookDto = modelMapper.map(favouriteBook, FavouriteBookDto.class);
        favouriteBookDto.setBookDto(modelMapper.map(favouriteBook.getBook(),BookDto.class));
        favouriteBookDto.setCustomerDto(modelMapper.map(favouriteBook.getCustomer(),CustomerDto.class));
        return  favouriteBookDto;

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
    public FavouriteBookDto updateFavouriteBook(FavouriteBookDto favouritebookDto, Integer id) {
        FavouriteBook updatedFavBook = modelMapper.map(favouritebookDto, FavouriteBook.class);
        FavouriteBook favouriteBookFromDB = favouriteBookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find favourite book with specified id=" + id));

        favouriteBookFromDB.setBook(updatedFavBook.getBook());
        favouriteBookFromDB.setCustomer(updatedFavBook.getCustomer());

        return modelMapper.map(favouriteBookRepository.save(favouriteBookFromDB),FavouriteBookDto.class);
    }

    @Override
    public FavouriteBookDto insertFavouriteBook(FavouriteBookDto favouritebookDto) {

        FavouriteBook favouriteBook = modelMapper.map(favouritebookDto, FavouriteBook.class);
        favouriteBookRepository.save(favouriteBook);
        return modelMapper.map(favouriteBook, FavouriteBookDto.class);
    }

    @Override
    public Collection<FavouriteBookDto> getFavouriteByCustomerId(Integer customerId) {
        Collection<FavouriteBook> favouriteBooks = favouriteBookRepository.findByCustomerId(customerId);

        Collection<FavouriteBookDto> favouriteBookDtos = new ArrayList<>();
        FavouriteBookDto favouriteBookDto = new FavouriteBookDto();
        for (FavouriteBook favBook : favouriteBooks) {
            favouriteBookDto = modelMapper.map(favBook, FavouriteBookDto.class);
            favouriteBookDto.setBookDto(modelMapper.map(favBook.getBook(), BookDto.class));
            favouriteBookDto.setCustomerDto(modelMapper.map(favBook.getCustomer(), CustomerDto.class));
            favouriteBookDtos.add(favouriteBookDto);
        }
        return favouriteBookDtos;
    }

    public FavouriteBookDto getFavouriteByCustomerIdAndBookId(Integer customerId, Integer bookId) {
        FavouriteBook favouriteBook = favouriteBookRepository.findByCustomerIdAndBookId(customerId, bookId).orElseThrow(() -> new EntityNotFoundException("Could not find favourite book"));
        FavouriteBookDto favouriteBookDto = modelMapper.map(favouriteBook, FavouriteBookDto.class);
        return favouriteBookDto;
    }
}
