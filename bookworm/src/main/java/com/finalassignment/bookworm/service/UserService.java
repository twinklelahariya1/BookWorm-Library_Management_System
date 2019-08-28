package com.finalassignment.bookworm.service;

import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.model.User;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);
    List<User> getUser();
    User findById(Long userId);
}
