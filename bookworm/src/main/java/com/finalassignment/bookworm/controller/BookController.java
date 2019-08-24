package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/bookworm/populateBook")
    public ResponseEntity<Book> populateBook(@RequestBody Book book) {

        Book addBook = bookService.addBook(book);
        return new ResponseEntity(addBook, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping("/bookworm/showAllBooks")
    public ResponseEntity<List> showAllBooks() {
        return ResponseEntity.ok(bookService.getBook());

    }
}
