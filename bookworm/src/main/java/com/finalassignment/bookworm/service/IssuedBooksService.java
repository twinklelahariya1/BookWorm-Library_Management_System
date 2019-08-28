package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.IssuedBooks;
import com.finalassignment.bookworm.model.UserLibraryCard;

import java.util.List;

public interface IssuedBooksService {

    IssuedBooksDto addBooksToCard(IssuedBooksDto issuedBooksDto, Book book, UserLibraryCard userLibraryCard);
    List<IssuedBooks> getIssuedBookDetails();
    IssuedBooks findById(Long issueId);
    void deleteIssue(Long issueId);
}
