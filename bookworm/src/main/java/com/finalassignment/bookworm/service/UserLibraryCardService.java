package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.UserLibraryCard;

import java.util.List;

public interface UserLibraryCardService {

    UserLibraryCard addLibraryCardEntry(UserLibraryCard userLibraryCard);
    List<UserLibraryCard> getCardDetails();
}
