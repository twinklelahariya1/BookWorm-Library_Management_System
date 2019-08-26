package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.BookInventory;

import java.util.List;

public interface BookInventoryService {

    BookInventory addBookInventoryEntry(BookInventory bookInventory);
    List<BookInventory> getBookInventoryDetails();
    BookInventory findById(Long uId);
}
