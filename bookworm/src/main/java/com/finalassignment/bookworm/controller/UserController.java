package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.service.impl.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromUser;

@RestController
public class UserController {


    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/bookworm/addUser")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {

        UserDto addUser = userService.addUser(userDto);
        return new ResponseEntity(addUser, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping(value = "/bookworm/showUserById/{user_id}")
    public User showUserById(@PathVariable Long user_id) {
//        log.debug("Getting Customers By Id.");
        return userService.findById(user_id);
    }

    @GetMapping("/bookworm/showAllUsers")
    public ResponseEntity<List> showAllUsers() {
        return ResponseEntity.ok(userService.getUser());
    }


    @PatchMapping("/bookworm/payFine/{userId}")
    public ResponseEntity<Object> payFine(@PathVariable Long userId) {

        userService.resetFine(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Amount paid");
    }
}
