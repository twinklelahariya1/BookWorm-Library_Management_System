package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);
    List<Author> getAuthor();
}
