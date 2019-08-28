package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.exception.DataNotFoundException;
import com.finalassignment.bookworm.model.*;
import com.finalassignment.bookworm.repository.IssuedBooksRepository;
import com.finalassignment.bookworm.service.IssuedBooksService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromIssuedBooksDto;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {


    private final IssuedBooksRepository issuedBooksRepository;
    private final BookInventoryServiceImpl bookInventoryService;
    private final UserServiceImpl userService;

    public IssuedBooksServiceImpl(IssuedBooksRepository issuedBooksRepository, BookInventoryServiceImpl bookInventoryService, UserServiceImpl userService) {
        this.issuedBooksRepository = issuedBooksRepository;
        this.bookInventoryService = bookInventoryService;
        this.userService = userService;
    }


    @Override
    public IssuedBooksDto addBooksToCard(IssuedBooksDto issuedBooksDto, Book book, UserLibraryCard userLibraryCard) {

        IssuedBooks issuedBooks = fromIssuedBooksDto(issuedBooksDto);
        issuedBooks.setBooks(book);
        issuedBooks.setUserLibraryCard(userLibraryCard);
        issuedBooksRepository.save(issuedBooks);
        return issuedBooksDto;
    }

    @Override
    public List<IssuedBooks> getIssuedBookDetails() {

        return issuedBooksRepository.findAll();
    }

    @Override
    public IssuedBooks findById(Long issueId) {

        return issuedBooksRepository.findById(issueId).orElseThrow(() -> new DataNotFoundException("Issue with id "+issueId+" Not found"));
    }

    @Override
    public void deleteIssue(Long issueId,Long userId, Long inventoryId) {

        deletionUtil(issueId,userId,inventoryId);
        issuedBooksRepository.deleteById(issueId);
    }

    private void deletionUtil(Long issueId,Long userId,Long inventoryId) {
        IssuedBooks issuedBooks = issuedBooksRepository.findById(issueId).orElseThrow(()-> new DataNotFoundException("Issue with id "+issueId+" Not found"));

        BookInventory bookInventory = bookInventoryService.findById(inventoryId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks() + 1);

        LocalDate issueDate = issuedBooks.getIssueDate();
        LocalDate returnDate = LocalDate.now();

        Period period = Period.between(issueDate, returnDate);
        int difference = period.getDays();

        User user = userService.findById(userId);

        if (difference > 7) {
            int fine = difference * 5;
            user.setUserTotalFineAmount(user.getUserTotalFineAmount()+fine);
        }
    }
}
