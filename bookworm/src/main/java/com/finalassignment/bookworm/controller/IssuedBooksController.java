package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.*;
import com.finalassignment.bookworm.service.impl.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
public class IssuedBooksController {

    private final IssuedBooksServiceImpl issuedBooksService;
    private final BookServiceImpl bookService;
    private  final UserLibraryCardServiceImpl userLibraryCardService;
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
    public ResponseEntity<IssuedBooks> addIssueBook(@RequestBody IssuedBooks issuedBooks, @PathVariable Long bookId, @PathVariable Long cardId) {


        BookInventory bookInventory= bookInventoryService.findById(bookId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks()-1);
        bookInventoryService.addBookInventoryEntry(bookInventory);

        Book book = bookService.findById(bookId);
        issuedBooks.setBooks(book);

        UserLibraryCard userLibraryCard= userLibraryCardService.findById(cardId);
        issuedBooks.setUserLibraryCard(userLibraryCard);

        return new ResponseEntity(issuedBooksService.addBooksToCard(issuedBooks), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/bookworm/returnBook/{issueId}")
    public ResponseEntity<Object> returnBook(@PathVariable Long issueId){

        IssuedBooks issuedBooks=issuedBooksService.findById(issueId);
        Book book= issuedBooks.getBooks();
        Long bookId=book.getBookId();

        BookInventory bookInventory= bookInventoryService.findById(bookId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks()+1);
        bookInventoryService.addBookInventoryEntry(bookInventory);

        LocalDate issueDate= issuedBooks.getIssueDate();
        LocalDate returnDate = LocalDate.now();

        Period period = Period.between(issueDate,returnDate);
        int difference = period.getDays();

        UserLibraryCard userLibraryCard=issuedBooks.getUserLibraryCard();
        Long cardId=userLibraryCard.getCardId();

        User user = userService.findById(cardId);

        if(difference > 7){
            int fine = difference*5;
            user.setUserTotalFineAmount(user.getUserTotalFineAmount()+fine);
        }



        issuedBooksService.deleteIssue(issueId);

        return  ResponseEntity.status(HttpStatus.OK).body("The data is deleted");
    }

    @PostMapping("/bookworm/payFine/{userId}")
    public ResponseEntity<Object> addIssueBook(@PathVariable Long userId){

        User user=userService.findById(userId);
        user.setUserTotalFineAmount(0);
        return ResponseEntity.status(HttpStatus.OK).body("Amount paid");
    }
}
