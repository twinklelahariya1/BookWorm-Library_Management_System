package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private final BookServiceImpl bookService;
    private  final AuthorServiceImpl authorService;
    private final GenreServiceImpl genreService;

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService, GenreServiceImpl genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @PostMapping("/bookworm/addBook/{authorId}/{genreId}")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book, @PathVariable Long authorId, @PathVariable Long genreId) {

        Author author = authorService.findById(authorId);
        Genre genre = genreService.findById(genreId);

        book.setAuthor(author);
        book.setGenre(genre);

        return new ResponseEntity(bookService.addBook(book), new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookworm/showBookById/{book_id}")
    public Book showBookById(@PathVariable Long book_id) {
//        log.debug("Getting Customers By Id.");
        return bookService.findById(book_id);
    }

    @GetMapping("/bookworm/showAllBooks")
    public ResponseEntity<List> showAllBooks() {

        return ResponseEntity.ok(bookService.getBook());

    }

}
