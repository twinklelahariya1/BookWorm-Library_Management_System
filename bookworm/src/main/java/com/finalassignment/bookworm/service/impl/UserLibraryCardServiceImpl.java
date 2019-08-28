package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.UserLibraryCardDto;
import com.finalassignment.bookworm.exception.UserLibraryCardNotFoundException;
import com.finalassignment.bookworm.model.User;
import com.finalassignment.bookworm.model.UserLibraryCard;
import com.finalassignment.bookworm.repository.UserLibraryCardRepository;
import com.finalassignment.bookworm.service.UserLibraryCardService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromUserLibraryCardDto;


@Service
public class UserLibraryCardServiceImpl implements UserLibraryCardService {


    private final UserLibraryCardRepository userLibraryCardRepository;

    public UserLibraryCardServiceImpl(UserLibraryCardRepository userLibraryCardRepository) {
        this.userLibraryCardRepository = userLibraryCardRepository;
    }


    @Override
    public UserLibraryCardDto addLibraryCardEntry(UserLibraryCardDto userLibraryCardDto, User user) {
        UserLibraryCard userLibraryCard = fromUserLibraryCardDto(userLibraryCardDto);
        userLibraryCard.setUser(user);
        userLibraryCardRepository.save(userLibraryCard);
        return userLibraryCardDto;
    }

    @Override
    public List<UserLibraryCard> getCardDetails() {

        return userLibraryCardRepository.findAll();
    }

    @Override
    public UserLibraryCard findById(Long cardId) {

        return userLibraryCardRepository.findById(cardId).orElseThrow(() -> new UserLibraryCardNotFoundException(cardId));
    }
}
