package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.model.IssuedBooks;
import com.finalassignment.bookworm.repository.IssuedBooksRepository;
import com.finalassignment.bookworm.service.IssuedBooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {


    private final IssuedBooksRepository issuedBooksRepository;

    public IssuedBooksServiceImpl(IssuedBooksRepository issuedBooksRepository) {
        this.issuedBooksRepository = issuedBooksRepository;
    }

    @Override
    public IssuedBooks addBooksToCard(IssuedBooks issuedBooks) {
        return issuedBooksRepository.save(issuedBooks);
    }

    @Override
    public List<IssuedBooks> getIssuedBookDetails() {
        return issuedBooksRepository.findAll();
    }
}
