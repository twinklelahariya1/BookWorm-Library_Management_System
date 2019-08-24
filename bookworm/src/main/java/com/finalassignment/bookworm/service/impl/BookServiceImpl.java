package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.exception.GenreNotFoundException;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.Genre;
import com.finalassignment.bookworm.repository.AuthorRepository;
import com.finalassignment.bookworm.repository.BookRepository;
import com.finalassignment.bookworm.repository.GenreRepository;
import com.finalassignment.bookworm.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book addBook(Book book) {


        book = bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }
}
