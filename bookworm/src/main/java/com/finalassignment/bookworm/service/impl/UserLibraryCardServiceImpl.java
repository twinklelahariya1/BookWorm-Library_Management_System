package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.exception.UserNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.repository.UserLibraryCardRepository;
import com.finalassignment.bookworm.service.UserLibraryCardService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLibraryCardServiceImpl implements UserLibraryCardService {


    private final UserLibraryCardRepository userLibraryCardRepository;

    public UserLibraryCardServiceImpl(UserLibraryCardRepository userLibraryCardRepository) {
        this.userLibraryCardRepository = userLibraryCardRepository;
    }


    @Override
    public UserLibraryCard addLibraryCardEntry(UserLibraryCard userLibraryCard) {
        userLibraryCard = userLibraryCardRepository.save(userLibraryCard);
        return userLibraryCard;
    }

    @Override
    public List<UserLibraryCard> getCardDetails() {
        return userLibraryCardRepository.findAll();
    }

    @Override
    public UserLibraryCard findById(Long cardId) {
        return userLibraryCardRepository.findById(cardId).orElseThrow(()-> new UserNotFoundException(cardId));
    }
}
