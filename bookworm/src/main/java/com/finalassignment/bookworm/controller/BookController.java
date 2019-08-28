package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 *Controlling Addition and finding of book and fetches from the database.
 */
@Slf4j
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

    /**
     * Adding book to the database mapping with author and genre the book belongs to.
     * @param bookDto
     * @param authorId
     * @param genreId
     * @return
     */
    @PostMapping("/bookworm/addBook/{authorId}/{genreId}")
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto bookDto, @PathVariable Long authorId, @PathVariable Long genreId) {
        Author author = authorService.findById(authorId);
        Genre genre = genreService.findById(genreId);

        return new ResponseEntity(bookService.addBook(bookDto,author,genre), new HttpHeaders(), HttpStatus.OK);

    }

    /**
     * Fetching book details from database and referred by book id.
     * @param book_id
     * @return
     */
    @GetMapping(value = "/bookworm/showBookById/{book_id}")
    public Book showBookById(@PathVariable Long book_id) {
        log.debug("Getting books By Id.");
        return bookService.findById(book_id);
    }

    /**
     * Fetching details about all the books from database.
     * @return
     */
    @GetMapping("/bookworm/showAllBooks")
    public ResponseEntity<List> showAllBooks() {
        return ResponseEntity.ok(bookService.getBook());

    }

}
