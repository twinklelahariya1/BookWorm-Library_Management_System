package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author addAuthor(Author author);
    List<Author> getAuthor();
    Author findById(Long authorId);
}
