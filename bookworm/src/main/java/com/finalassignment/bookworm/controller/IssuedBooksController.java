package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.model.*;
import com.finalassignment.bookworm.service.impl.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromBookInventory;

@RestController
public class IssuedBooksController {

    private final IssuedBooksServiceImpl issuedBooksService;
    private final BookServiceImpl bookService;
    private final UserLibraryCardServiceImpl userLibraryCardService;
    private final BookInventoryServiceImpl bookInventoryService;
    private final UserServiceImpl userService;

    public IssuedBooksController(IssuedBooksServiceImpl issuedBooksService, BookServiceImpl bookService, UserLibraryCardServiceImpl userLibraryCardService, BookInventoryServiceImpl bookInventoryService, UserServiceImpl userService) {
        this.issuedBooksService = issuedBooksService;
        this.bookService = bookService;
        this.userLibraryCardService = userLibraryCardService;
        this.bookInventoryService = bookInventoryService;
        this.userService = userService;
    }

    @GetMapping("/bookworm/showAllIssuedBooks")
    public ResponseEntity<List> showIssuedBookDetails() {
        return ResponseEntity.ok(issuedBooksService.getIssuedBookDetails());

    }

    @PostMapping("/bookworm/issueBook/{bookId}/{cardId}")
    public ResponseEntity<IssuedBooksDto> issueBook(@Valid @RequestBody IssuedBooksDto issuedBooksDto, @PathVariable Long bookId, @PathVariable Long cardId) {

        Book book = bookService.findById(bookId);
        UserLibraryCard userLibraryCard = userLibraryCardService.findById(cardId);

        BookInventory bookInventory= bookInventoryService.findById(bookId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks()-1);
        return new ResponseEntity(issuedBooksService.addBooksToCard(issuedBooksDto, book, userLibraryCard), new HttpHeaders(), HttpStatus.OK);
    }
    @DeleteMapping("/bookworm/returnBook/{issueId}")
    public ResponseEntity<Object> returnBook(@PathVariable Long issueId) {

        issuedBooksService.deleteIssue(issueId);

        return ResponseEntity.status(HttpStatus.OK).body("The data is deleted");
    }


}
