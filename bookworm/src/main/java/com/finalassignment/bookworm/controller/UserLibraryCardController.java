package com.finalassignment.bookworm.controller;


import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.dto.UserLibraryCardDto;
import com.finalassignment.bookworm.model.User;
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


    @PostMapping("/bookworm/generateUserCard/{userId}")
    public ResponseEntity<UserLibraryCardDto> generateUserCard(@Valid @RequestBody UserLibraryCardDto userLibraryCardDto, @PathVariable Long userId) {

        User user = userService.findById(userId);

        UserLibraryCardDto addCard = userLibraryCardService.addLibraryCardEntry(userLibraryCardDto,user);
        return new ResponseEntity(addCard, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/bookworm/showAllCards")
    public ResponseEntity<List> showAllCards() {
        return ResponseEntity.ok(userLibraryCardService.getCardDetails());

    }

}