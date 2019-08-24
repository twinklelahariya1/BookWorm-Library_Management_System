package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.exception.GenreNotFoundException;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/bookworm/populateGenre")
    public ResponseEntity<Genre> populateGenre(@RequestBody Genre genre) {

        Genre addGenre = genreService.addGenre(genre);
        return new ResponseEntity(addGenre, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping(value = "/bookworm/showGenre/{genre_id}")
    public Genre getGenreById(@PathVariable Long genre_id) {
//        log.debug("Getting Customers By Id.");
        return genreService.findById(genre_id).orElseThrow(()-> new GenreNotFoundException(genre_id));
    }

    @GetMapping("/bookworm/showAllGenres")
    public ResponseEntity<List> showAllGenres() {
        return ResponseEntity.ok(genreService.getGenre());

    }
}
