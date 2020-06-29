package com.library.library.service;

import com.library.library.dto.BookDto;
import com.library.library.dto.BookGenreDto;
import com.library.library.dto.GenreDto;
import com.library.library.model.*;
import com.library.library.repository.BookGenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookGenreImplementation implements BookGenreService {

    @Autowired
    private BookGenreRepository bookGenreRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private GenreService genreService;

    @Override
    public Collection<BookGenreDto> getAllBookGenre() {

        Collection<BookGenre> bookGenres = bookGenreRepository.findAll();
        Collection<BookGenreDto> bookGenresDto = new ArrayList<>();
        BookGenreDto bookGenreDto = new BookGenreDto();
        for (BookGenre bookGenre : bookGenres) {
            bookGenreDto = modelMapper.map(bookGenre, BookGenreDto.class);
            bookGenreDto.setGenreDto(modelMapper.map(bookGenre.getGenre(), GenreDto.class));
            bookGenreDto.setBookDto(modelMapper.map(bookGenre.getBook(), BookDto.class));
            bookGenresDto.add(bookGenreDto);
        }
        return bookGenresDto;
    }

    @Override
    public BookGenreDto getBookGenreById(Integer id) {
        //preuzima bookgenre iz baze
        BookGenre bookGenre = bookGenreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find book genre with id=" + id));
        //preuzima book_genre i pretvara u dto
        BookGenreDto bookGenreDto = modelMapper.map(bookGenre, BookGenreDto.class);
        //postavlja book dto i genre dto u book genre dto
        bookGenreDto.setGenreDto(modelMapper.map(bookGenre.getGenre(), GenreDto.class));
        bookGenreDto.setBookDto(modelMapper.map(bookGenre.getBook(), BookDto.class));
        //vraca bookgernedto
        return bookGenreDto;
    }

    @Override
    public BookGenreDto postBookGenre(BookGenreDto bookGenreDto) {
        BookGenre bookGenre = modelMapper.map(bookGenreDto, BookGenre.class);
        BookGenre bookGenreSaved = bookGenreRepository.save(bookGenre);
        BookGenreDto bookGenreDtoSaved = modelMapper.map(bookGenreSaved, BookGenreDto.class);
        return bookGenreDtoSaved;
    }

    @Override
    public void deleteBookGenre(Integer id) {
        bookGenreRepository.deleteById(id);
    }

    @Override
    public BookGenreDto updateBookGenre(BookGenreDto bookGenreDto, Integer id) {
        BookGenre bookGenreFromDB = bookGenreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order item with specified id=" + id));
        bookGenreFromDB.setBook(modelMapper.map(bookGenreDto.getBookDto(), Book.class));
        bookGenreFromDB.setGenre(modelMapper.map(bookGenreDto.getGenreDto(), Genre.class));
        BookGenre bookGenreUpdated = bookGenreRepository.save(bookGenreFromDB);
        BookGenreDto bookGenreUpdatedDto = modelMapper.map(bookGenreUpdated, BookGenreDto.class);
        return bookGenreUpdatedDto;
    }

    @Override
    public Collection<BookDto> getBooksByGenre(Integer genreId) {
        GenreDto genreDto = genreService.getGenreById(genreId);
        Genre genre = modelMapper.map(genreDto, Genre.class);
        Collection<BookGenre> bookGenres = bookGenreRepository.findByGenre(genre).orElseThrow(() -> new EntityNotFoundException("Could not find book by specified genre"));
        Collection<BookGenreDto> bookGenresDto = new ArrayList<>();
        BookGenreDto bookGenreDto = new BookGenreDto();
        for (BookGenre bookGenre : bookGenres) {
            bookGenreDto = modelMapper.map(bookGenre, BookGenreDto.class);
            bookGenreDto.setGenreDto(modelMapper.map(bookGenre.getGenre(), GenreDto.class));
            bookGenreDto.setBookDto(modelMapper.map(bookGenre.getBook(), BookDto.class));
            bookGenresDto.add(bookGenreDto);
        }
        Collection<BookDto> books = new ArrayList<>();
        for (BookGenreDto item : bookGenresDto) {
            books.add(item.getBookDto());
        }
        return books;
    }

   /* private BookGenreDto entityToDto(BookGenre bookGenre) {
        BookGenreDto bookGenreDto = new BookGenreDto();
        bookGenreDto.setId(bookGenre.getId());
        bookGenreDto.setBookDto(bookEntityToDto(bookGenre.getBook()));
        bookGenreDto.setGenreDto(genreEntityToDto(bookGenre.getGenre()));
        return bookGenreDto;
    }

    private BookGenre dtoToEntity(BookGenreDto bookGenreDto) {
        BookGenre bookGenre = new BookGenre();
        bookGenre.setId(bookGenreDto.getId());
        bookGenre.setBook(bookDtoToEntity(bookGenreDto.getBookDto()));
        bookGenre.setGenre(genreDtoToEntity(bookGenreDto.getGenreDto()));
        return bookGenre;
    }*/

   /* private BookDto bookEntityToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setBookDescription(book.getBookDescription());
        bookDto.setBookName(book.getBookName());
        bookDto.setBookLanguage(book.getBookLanguage());
        bookDto.setBookPrice(book.getBookPrice());
        bookDto.setBookPublisher(book.getBookPublisher());
        bookDto.setBookYear(book.getBookYear());
        bookDto.setBookQuantity(book.getBookQuantity());
        return bookDto;
    }

    private Book bookDtoToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookAuthor(bookDto.getBookAuthor());
        book.setBookDescription(bookDto.getBookDescription());
        book.setBookName(bookDto.getBookName());
        book.setBookLanguage(bookDto.getBookLanguage());
        book.setBookPrice(bookDto.getBookPrice());
        book.setBookPublisher(bookDto.getBookPublisher());
        book.setBookYear(bookDto.getBookYear());
        book.setBookQuantity(bookDto.getBookQuantity());
        return book;
    }

    private GenreDto genreEntityToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setGenreName(genre.getGenreName());

        return genreDto;
    }

    private Genre genreDtoToEntity(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setGenreName(genreDto.getGenreName());

        return genre;
    }*/
}
