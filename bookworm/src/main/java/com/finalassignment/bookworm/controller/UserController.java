package com.finalassignment.bookworm.controller;

import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.service.impl.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/bookworm/populateUser")
    public ResponseEntity<User> populateUser(@RequestBody User user) {

        User addUser = userService.addUser(user);
        return new ResponseEntity(addUser, new HttpHeaders(), HttpStatus.OK);

    }


    @GetMapping(value = "/bookworm/showUser/{user_id}")
    public User getUserById(@PathVariable Long user_id) {
//        log.debug("Getting Customers By Id.");
        return userService.findById(user_id);
    }

    @GetMapping("/bookworm/showAllUsers")
    public ResponseEntity<List> showAllUsers() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping("/bookworm/payFine/{userId}")
    public ResponseEntity<Object> addIssueBook(@PathVariable Long userId){

        User user=userService.findById(userId);
        user.setUserTotalFineAmount(0);
        return ResponseEntity.status(HttpStatus.OK).body("Amount paid");
    }
}
