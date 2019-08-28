package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.BookDto;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.Genre;

import java.util.List;

public interface BookService {

    BookDto addBook(BookDto bookDto, Author author, Genre genre);
    List<Book> getBook();
    Book findById(Long bookId);
}
