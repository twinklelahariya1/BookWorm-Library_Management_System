package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    List<User> getUser();
    User findById(Long userId);
}
