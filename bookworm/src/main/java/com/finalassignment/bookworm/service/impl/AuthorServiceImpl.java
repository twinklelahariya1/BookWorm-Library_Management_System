package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.repository.AuthorRepository;
import com.finalassignment.bookworm.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author addAuthor(Author author) {
        author = authorRepository.save(author);
        return author;
    }

    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
    }


}
