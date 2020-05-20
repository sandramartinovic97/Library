package com.library.library.service;

import com.library.library.dto.BookDto;
import com.library.library.dto.BookGenreDto;
import com.library.library.dto.GenreDto;
import com.library.library.model.Book;
import com.library.library.model.BookGenre;
import com.library.library.model.Genre;
import com.library.library.repository.BookGenreRepository;
import com.library.library.repository.BookRepository;
import com.library.library.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookGenreImplementation implements BookGenreService{

    @Autowired
    private BookGenreRepository bookGenreRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;

    private ModelMapper modelMapper=new ModelMapper();

    @Override
    public Collection<BookGenreDto> getAllBookGenre() {

        Collection<BookGenre> bookGenres = bookGenreRepository.findAll();
        Collection<BookGenreDto> bookGenresDto = new ArrayList<>();
        BookGenreDto bookGenreDto=new BookGenreDto();
        for (BookGenre bookGenre : bookGenres) {
            bookGenreDto=modelMapper.map(bookGenre, BookGenreDto.class);
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
        BookGenreDto bookGenreDto =modelMapper.map(bookGenre, BookGenreDto.class);
        //postavlja book dto i genre dto u book genre dto
        bookGenreDto.setGenreDto(modelMapper.map(bookGenre.getGenre(), GenreDto.class));
        bookGenreDto.setBookDto(modelMapper.map(bookGenre.getBook(), BookDto.class));
        //vraca bookgernedto
        return bookGenreDto;
    }

    @Override
    public BookGenreDto postBookGenre(BookGenreDto bookGenreDto) {
        /*Book book = bookRepository.findById(bookGenreDto.getBookDto().getId()).orElseThrow(() -> new EntityNotFoundException("Could not find book"));
        Genre genre = genreRepository.findById(bookGenreDto.getGenreDto().getId()).orElseThrow(() -> new EntityNotFoundException("Could not find genre"));
        bookGenreDto.setBookDto(modelMapper.map(book, BookDto.class));
        bookGenreDto.setGenreDto(modelMapper.map(genre, GenreDto.class));*/
        BookGenre bookGenre = modelMapper.map(bookGenreDto, BookGenre.class);
        /*bookGenre.setGenre(modelMapper.map(bookGenreDto.getGenreDto(), Genre.class));
        bookGenre.setBook(modelMapper.map(bookGenreDto.getBookDto(), Book.class));*/
        BookGenre bookGenreSaved=bookGenreRepository.save(bookGenre);
        BookGenreDto bookGenreDtoSaved = new  BookGenreDto();
        bookGenreDtoSaved.setGenreDto(modelMapper.map(bookGenreSaved.getGenre(), GenreDto.class));
        bookGenreDtoSaved.setBookDto(modelMapper.map(bookGenreSaved.getBook(), BookDto.class));
        return modelMapper.map(bookGenreSaved, BookGenreDto.class);
    }

    @Override
    public void deleteBookGenre(Integer id) {
        bookGenreRepository.deleteById(id);
    }

    @Override
    public BookGenreDto updateBookGenre(BookGenreDto bookGenreDto, Integer id) {
        BookGenre updatedBookGenre = modelMapper.map(bookGenreDto, BookGenre.class);
        BookGenre bookGenreFromDB = bookGenreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order item with specified id=" + id));
        bookGenreFromDB.setBook(updatedBookGenre.getBook());
        bookGenreFromDB.setGenre(updatedBookGenre.getGenre());
        return modelMapper.map(bookGenreRepository.save(bookGenreFromDB), BookGenreDto.class);
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
