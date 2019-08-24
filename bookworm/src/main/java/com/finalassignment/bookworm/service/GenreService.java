package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Genre;

import java.util.List;

public interface GenreService {

    Genre addGenre(Genre genre);
    List<Genre> getGenre();
}
