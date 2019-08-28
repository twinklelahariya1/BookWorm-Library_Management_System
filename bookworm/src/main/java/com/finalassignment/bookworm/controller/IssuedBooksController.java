package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.BookInventory;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.service.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
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

    @GetMapping("/bookworm/user/showAllIssuedBooks")
    public ResponseEntity<List> showIssuedBookDetails() {

        log.info("Showing issue id's");
        return ResponseEntity.ok(issuedBooksService.getIssuedBookDetails());

    }

    @PostMapping("/bookworm/user/issueBook/{bookId}/{cardId}")
    public ResponseEntity<IssuedBooksDto> issueBook(@Valid @RequestBody IssuedBooksDto issuedBooksDto, @PathVariable Long bookId, @PathVariable Long cardId) {


        log.info("Issuing a book using book id and user card id");
        Book book = bookService.findById(bookId);
        UserLibraryCard userLibraryCard = userLibraryCardService.findById(cardId);

        BookInventory bookInventory= bookInventoryService.findById(bookId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks()-1);
        return new ResponseEntity(issuedBooksService.addBooksToCard(issuedBooksDto, book, userLibraryCard), new HttpHeaders(), HttpStatus.OK);
    }
    @DeleteMapping("/bookworm/user/returnBook/{issueId}")
    public ResponseEntity<Object> returnBook(@PathVariable Long issueId) {

        log.info("Returning book");
        issuedBooksService.deleteIssue(issueId);

        return ResponseEntity.status(HttpStatus.OK).body("The data is deleted");
    }


}
