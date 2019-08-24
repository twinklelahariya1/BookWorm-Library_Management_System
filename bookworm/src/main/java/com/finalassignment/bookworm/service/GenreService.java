package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    Genre addGenre(Genre genre);
    List<Genre> getGenre();
    Genre findById(Long genreId);
}
