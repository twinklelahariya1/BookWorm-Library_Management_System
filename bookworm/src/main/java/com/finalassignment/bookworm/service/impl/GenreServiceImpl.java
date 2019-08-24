package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.GenreNotFoundException;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.repository.GenreRepository;
import com.finalassignment.bookworm.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public Genre addGenre(Genre genre) {
        genre = genreRepository.save(genre);
        return genre;
    }

    @Override
    public List<Genre> getGenre() {

        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long genreId) {
        return genreRepository.findById(genreId).orElseThrow(() -> new GenreNotFoundException(genreId));
    }


}
