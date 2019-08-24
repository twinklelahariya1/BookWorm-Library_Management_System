package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.AuthorNotFoundException;
import com.finalassignment.bookworm.exception.UserNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.repository.UserRepository;
import com.finalassignment.bookworm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
    }
}
