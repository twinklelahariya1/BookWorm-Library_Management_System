package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.service.impl.GenreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlling Addition and finding of Genre and fetches from the database.
 */
@Slf4j
@RestController
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    /**
     * Taking gener data in requestbody and storing it to database
     * @param genreDto
     * @return
     */
    @PostMapping("/bookworm/addGenre")
    public ResponseEntity<GenreDto> addGenre(@Valid @RequestBody GenreDto genreDto) {

        GenreDto addGenre = genreService.addGenre(genreDto);
        return new ResponseEntity(addGenre, new HttpHeaders(), HttpStatus.OK);

    }

    /**
     * Fetching data from database with references to id
     * @param genre_id
     * @return
     */
    @GetMapping(value = "/bookworm/showGenreById/{genre_id}")
    public Genre showGenreById(@PathVariable Long genre_id) {
        log.debug("Getting Genre By Id.");
        return genreService.findById(genre_id);
    }

    /**
     * Showing data from database of all the gener
     * @return
     */
    @GetMapping("/bookworm/showAllGenres")
    public ResponseEntity<List> showAllGenres() {

        log.info("Showing list of all the Genres in library");
        return ResponseEntity.ok(genreService.getGenre());

    }
}
