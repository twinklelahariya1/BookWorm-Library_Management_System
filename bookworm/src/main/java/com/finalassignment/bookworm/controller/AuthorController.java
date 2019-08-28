package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.service.impl.AuthorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlling Addition and finding of Author and fetches from the database.
 */

@Slf4j
@RestController
public class AuthorController {


    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {

        this.authorService = authorService;
    }


    /**
     *Using post mapping to take data from user in terms of RequestBody and adding data to the database.
     * @param authorDto
     * @return
     */
    @PostMapping("/bookworm/addAuthor")
    public ResponseEntity<AuthorDto> addAuthor(@Valid @RequestBody AuthorDto authorDto) {

        log.debug("Adding author to the library");
        AuthorDto addAuthor = authorService.addAuthor(authorDto);
        return new ResponseEntity(addAuthor, new HttpHeaders(), HttpStatus.OK);

    }

    /**
     *Getting admin data from database by id of the author
     * @param author_id
     * @return
     */
    @GetMapping(value = "/bookworm/showAuthorById/{author_id}")
    public Author showAuthorById(@PathVariable Long author_id) {

        log.debug("Showing Author by Id");
        return authorService.findById(author_id);
    }

    /**
     * Getting all the data of Author form database.
     * @return
     */
        @GetMapping("/bookworm/showAllAuthors")
    public ResponseEntity<List> showAllAuthors() {

        log.debug("Showing all the Authors whose books are present in library");
        return ResponseEntity.ok(authorService.getAuthor());
    }
}
