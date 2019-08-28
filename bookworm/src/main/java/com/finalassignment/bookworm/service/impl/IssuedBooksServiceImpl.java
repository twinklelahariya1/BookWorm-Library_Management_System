package com.finalassignment.bookworm.service.impl;


import com.finalassignment.bookworm.dto.IssuedBooksDto;
import com.finalassignment.bookworm.exception.IssueBookNotFoundException;
import com.finalassignment.bookworm.model.*;
import com.finalassignment.bookworm.repository.IssuedBooksRepository;
import com.finalassignment.bookworm.service.IssuedBooksService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.*;

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

        return issuedBooksRepository.findById(issueId).orElseThrow(() -> new IssueBookNotFoundException(issueId));
    }

    @Override
    public void deleteIssue(Long issueId) {

        issuedBooksRepository.deleteById(issueId);
    }

    private void deletionUtil(Long issueId) {
        IssuedBooks issuedBooks = issuedBooksRepository.findById(issueId).orElseThrow(()-> new IssueBookNotFoundException(issueId));
        Book book = issuedBooks.getBooks();
        Long bookId = book.getBookId();

        BookInventory bookInventory = bookInventoryService.findById(bookId);
        bookInventory.setQuantityOfBooks(bookInventory.getQuantityOfBooks() + 1);
        bookInventoryService.addBookInventoryEntry(fromBookInventory(bookInventory),book);

        LocalDate issueDate = issuedBooks.getIssueDate();
        LocalDate returnDate = LocalDate.now();

        Period period = Period.between(issueDate, returnDate);
        int difference = period.getDays();

        UserLibraryCard userLibraryCard = issuedBooks.getUserLibraryCard();
        Long cardId = userLibraryCard.getCardId();

        User user = userService.findById(cardId);

        if (difference > 7) {
            int fine = difference * 5;
            user.setUserTotalFineAmount(user.getUserTotalFineAmount()+fine);
        }
    }
}
