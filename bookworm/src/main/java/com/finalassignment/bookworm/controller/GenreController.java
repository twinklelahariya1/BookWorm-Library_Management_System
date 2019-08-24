package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @GetMapping("/bookworm/showAllGenres")
    public ResponseEntity<List> showAllGenres() {
        return ResponseEntity.ok(genreService.getGenre());

    }
}
