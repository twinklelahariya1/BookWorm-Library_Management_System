package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class AuthorController {


    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {

        this.authorService = authorService;
    }

    @PostMapping("/bookworm/addAuthor")
    public ResponseEntity<AuthorDto> addAuthor(@Valid @RequestBody AuthorDto authorDto) {

        log.debug("Adding author to the library");
        AuthorDto addAuthor = authorService.addAuthor(authorDto);
        return new ResponseEntity(addAuthor, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookworm/showAuthorById/{author_id}")
    public Author showAuthorById(@PathVariable Long author_id) {

        log.debug("Showing Author by Id");
        return authorService.findById(author_id);
    }


    @GetMapping("/bookworm/showAllAuthors")
    public ResponseEntity<List> showAllAuthors() {

        log.debug("Showing all the Authors whose books are present in library");
        return ResponseEntity.ok(authorService.getAuthor());
    }
}
