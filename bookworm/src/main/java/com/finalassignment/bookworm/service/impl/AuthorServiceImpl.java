package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.repository.AuthorRepository;
import com.finalassignment.bookworm.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromAuthor;
import static com.finalassignment.bookworm.util.DtoUtil.fromAuthorDto;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = authorRepository.save(fromAuthorDto(authorDto));
        return authorDto;
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
