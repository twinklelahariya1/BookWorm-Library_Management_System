package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.dto.BookInventoryDto;
import com.finalassignment.bookworm.exception.BookNotFoundException;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.BookInventory;
import com.finalassignment.bookworm.repository.BookInventoryRepository;
import com.finalassignment.bookworm.service.BookInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromBookInventoryDto;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {


    private final BookInventoryRepository bookInventoryRepository;

    public BookInventoryServiceImpl(BookInventoryRepository bookInventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
    }


    @Override
    public BookInventoryDto addBookInventoryEntry(BookInventoryDto bookInventoryDto, Book book) {
        BookInventory bookInventory=fromBookInventoryDto(bookInventoryDto);
        bookInventory.setBook(book);
        bookInventoryRepository.save(bookInventory);
        return bookInventoryDto;
    }

    @Override
    public List<BookInventory> getBookInventoryDetails() {

        return bookInventoryRepository.findAll();
    }

    @Override
    public BookInventory findById(Long inventoryId) {
        return bookInventoryRepository.findById(inventoryId).orElseThrow(() -> new BookNotFoundException(inventoryId));

    }
}