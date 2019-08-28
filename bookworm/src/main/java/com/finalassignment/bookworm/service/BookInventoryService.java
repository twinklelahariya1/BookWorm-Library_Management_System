package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.BookInventoryDto;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.BookInventory;

import java.util.List;

public interface BookInventoryService {

    BookInventoryDto addBookInventoryEntry(BookInventoryDto bookInventoryDto, Book book);
    List<BookInventory> getBookInventoryDetails();
    BookInventory findById(Long uId);
}
