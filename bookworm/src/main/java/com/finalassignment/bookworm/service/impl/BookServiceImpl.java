package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.exception.BookNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.repository.BookRepository;
import com.finalassignment.bookworm.service.AuthorService;
import com.finalassignment.bookworm.service.BookService;
import com.finalassignment.bookworm.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromBookDto;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }


    @Override
    public BookDto addBook(BookDto bookDto, Author author, Genre genre) {
        Book book=fromBookDto(bookDto);
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepository.save(book);
        return bookDto;
    }

    @Override
    public List<Book> getBook() {

        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long bookId) {

        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }
}
