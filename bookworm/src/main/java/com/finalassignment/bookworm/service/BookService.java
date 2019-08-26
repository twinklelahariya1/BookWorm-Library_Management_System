package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    List<Book> getBook();
    Book findById(Long bookId);
}
