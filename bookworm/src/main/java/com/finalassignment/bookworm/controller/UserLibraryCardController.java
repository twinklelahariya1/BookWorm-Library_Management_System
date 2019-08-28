package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.UserLibraryCardDto;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.service.impl.BookServiceImpl;
import com.finalassignment.bookworm.service.impl.UserLibraryCardServiceImpl;
import com.finalassignment.bookworm.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
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


    @PostMapping("/bookworm/generateUserCard/{userId}")
    public ResponseEntity<UserLibraryCardDto> generateUserCard(@Valid @RequestBody UserLibraryCardDto userLibraryCardDto, @PathVariable Long userId) {

        log.info("Assigning a card to user");
        User user = userService.findById(userId);

        UserLibraryCardDto addCard = userLibraryCardService.addLibraryCardEntry(userLibraryCardDto, user);
        return new ResponseEntity(addCard, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/bookworm/showAllCards")
    public ResponseEntity<List> showAllCards() {

        log.info("Showing all the details of card");
        return ResponseEntity.ok(userLibraryCardService.getCardDetails());

    }

    @GetMapping("/bookworm/showCardById/{cardId}")
    public UserLibraryCard showCardById(@PathVariable Long cardId) {

        log.debug("Getting Card By Id.");
        return userLibraryCardService.findById(cardId);
    }
}