package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.IssuedBooks;
import com.finalassignment.bookworm.model.UserLibraryCard;

import java.util.List;

public interface IssuedBooksService {

    IssuedBooks addBooksToCard(IssuedBooks issuedBooks);
    List<IssuedBooks> getIssuedBookDetails();
}
