package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.GenreDto;
import com.finalassignment.bookworm.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    GenreDto addGenre(GenreDto genreDto);
    List<Genre> getGenre();
    Genre findById(Long genreId);
}
