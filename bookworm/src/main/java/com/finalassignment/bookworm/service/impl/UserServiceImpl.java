package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.UserDto;
import com.finalassignment.bookworm.exception.DataNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.repository.UserRepository;
import com.finalassignment.bookworm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromUserDto;

/**
 *
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userRepository.save(fromUserDto(userDto));
        return userDto;
    }

    @Override
    public List<User> getUser() {

        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {

        return userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User with id "+userId+" not found"));

    }


    public void resetFine(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new DataNotFoundException("User with id "+userId+" not found") );
        user.setUserTotalFineAmount(0);
        userRepository.save(user);

    }

}