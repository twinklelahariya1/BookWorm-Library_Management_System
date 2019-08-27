package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.UserLibraryCardServiceImpl;
import com.finalassignment.bookworm.service.impl.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserLibraryCardController {

    private final UserLibraryCardServiceImpl userLibraryCardService;

    private final UserServiceImpl userService;

    private final BookServiceImpl bookService;

    public UserLibraryCardController(UserLibraryCardServiceImpl userLibraryCardService, UserServiceImpl userService, BookServiceImpl bookService) {
        this.userLibraryCardService = userLibraryCardService;
        this.userService = userService;
        this.bookService = bookService;
    }


    @PostMapping("/bookworm/generateUserCard/{userId}/{bookId}")
    public ResponseEntity<UserLibraryCard> generateUserCard(@Valid @RequestBody UserLibraryCard userLibraryCard, @PathVariable Long userId, @PathVariable Long bookId) {

        Book book = bookService.findById(userId);
        User user = userService.findById(userId);

        UserLibraryCard addCard = userLibraryCardService.addLibraryCardEntry(userLibraryCard);
        return new ResponseEntity(addCard, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/bookworm/showAllCards")
    public ResponseEntity<List> showAllCards() {
        return ResponseEntity.ok(userLibraryCardService.getCardDetails());

    }

    @PostMapping("/bookworm/issue/{userId}")
    public ResponseEntity<UserLibraryCard> addIssue(@Valid @RequestBody UserLibraryCard userLibraryCard, @PathVariable Long userId) {
        User user = userService.findById(userId);
        userLibraryCard.setUser(user);
        return new ResponseEntity(userLibraryCardService.addLibraryCardEntry(userLibraryCard), new HttpHeaders(), HttpStatus.OK);
    }
}
