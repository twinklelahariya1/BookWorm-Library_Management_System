package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {


    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {

        this.authorService = authorService;
    }

    @PostMapping("/bookworm/populateAuthor")
    public ResponseEntity<Author> populateAuthor(@RequestBody Author author) {

        Author addAuthor = authorService.addAuthor(author);
        return new ResponseEntity(addAuthor, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookworm/showAuthor/{author_id}")
    public Author getAuthorById(@PathVariable Long author_id) {
//        log.debug("Getting Customers By Id.");
        return authorService.findById(author_id);
    }


    @GetMapping("/bookworm/showAllAuthors")
    public ResponseEntity<List> showAllAuthors() {

        return ResponseEntity.ok(authorService.getAuthor());
    }
}
