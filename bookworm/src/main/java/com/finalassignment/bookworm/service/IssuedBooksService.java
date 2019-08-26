package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.IssuedBooks;

import java.util.List;

public interface IssuedBooksService {

    IssuedBooks addBooksToCard(IssuedBooks issuedBooks);
    List<IssuedBooks> getIssuedBookDetails();
    IssuedBooks findById(Long issueId);
    void deleteIssue(Long issueId);
}
