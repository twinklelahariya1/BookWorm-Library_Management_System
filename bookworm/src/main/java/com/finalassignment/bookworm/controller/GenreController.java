package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/bookworm/addGenre")
    public ResponseEntity<GenreDto> addGenre(@Valid @RequestBody GenreDto genreDto) {

        GenreDto addGenre = genreService.addGenre(genreDto);
        return new ResponseEntity(addGenre, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping(value = "/bookworm/showGenreById/{genre_id}")
    public Genre showGenreById(@PathVariable Long genre_id) {
//        log.debug("Getting Customers By Id.");
        return genreService.findById(genre_id);
    }

    @GetMapping("/bookworm/showAllGenres")
    public ResponseEntity<List> showAllGenres() {
        return ResponseEntity.ok(genreService.getGenre());

    }
}
