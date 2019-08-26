package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.exception.UserNotFoundException;
import com.finalassignment.bookworm.model.BookInventory;
import com.finalassignment.bookworm.repository.BookInventoryRepository;
import com.finalassignment.bookworm.service.BookInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {


    private final BookInventoryRepository bookInventoryRepository;

    public BookInventoryServiceImpl(BookInventoryRepository bookInventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
    }

    @Override
    public BookInventory addBookInventoryEntry(BookInventory bookInventory) {
        bookInventory = bookInventoryRepository.save(bookInventory);
        return bookInventory;
    }

    @Override
    public List<BookInventory> getBookInventoryDetails() {
        return bookInventoryRepository.findAll();
    }

    @Override
    public BookInventory findById(Long inventoryId) {
        return bookInventoryRepository.findById(inventoryId).orElseThrow(()-> new UserNotFoundException(inventoryId));    }
}
