package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.BookInventory;
import com.finalassignment.bookworm.model.IssuedBooks;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.service.impl.BookInventoryServiceImpl;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.IssuedBooksServiceImpl;
import com.finalassignment.bookworm.service.impl.UserLibraryCardServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssuedBooksController {

    private final IssuedBooksServiceImpl issuedBooksService;
    private final BookServiceImpl bookService;
    private  final UserLibraryCardServiceImpl userLibraryCardService;
    private final BookInventoryServiceImpl bookInventoryService;

    public IssuedBooksController(IssuedBooksServiceImpl issuedBooksService, BookServiceImpl bookService, UserLibraryCardServiceImpl userLibraryCardService, BookInventoryServiceImpl bookInventoryService) {
        this.issuedBooksService = issuedBooksService;
        this.bookService = bookService;
        this.userLibraryCardService = userLibraryCardService;
        this.bookInventoryService = bookInventoryService;
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


        issuedBooksService.deleteIssue(issueId);

        return  ResponseEntity.status(HttpStatus.OK).body("The data is deleted");
    }
}
