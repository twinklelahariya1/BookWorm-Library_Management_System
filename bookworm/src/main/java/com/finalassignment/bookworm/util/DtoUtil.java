package com.finalassignment.bookworm.util;

import com.finalassignment.bookworm.dto.*;
import com.finalassignment.bookworm.model.*;

public class DtoUtil {

    public static AdminDto fromAdmin(final Admin admin) {

        return AdminDto.builder().adminContactNumber(admin.getAdminContactNumber())
                .adminEmail(admin.getAdminEmail())
                .adminName(admin.getAdminName())
                .adminPassword(admin.getAdminPassword())
                .build();

    }

    public static Admin fromAdminDto(final AdminDto adminDto) {

        return Admin.builder().adminContactNumber(adminDto.getAdminContactNumber())
                .adminEmail(adminDto.getAdminEmail())
                .adminName(adminDto.getAdminName())
                .adminPassword(adminDto.getAdminPassword())
                .build();
    }

    public static AuthorDto fromAuthor(final Author author) {


        return AuthorDto.builder().authorName(author.getAuthorName())
                .build();


    }

    public static Author fromAuthorDto(final AuthorDto authorDto) {

        return Author.builder().authorName(authorDto.getAuthorName()).build();
    }


    public static BookInventoryDto fromBookInventory(final BookInventory bookInventory) {

        BookInventoryDto bookInventoryDto = new BookInventoryDto();

        bookInventoryDto.setQuantityOfBooks(bookInventory.getQuantityOfBooks());
        bookInventoryDto.setBook(fromBook(bookInventory.getBook()));
        return bookInventoryDto;


    }

    public static BookInventory fromBookInventoryDto(final BookInventoryDto bookInventoryDto) {

        return BookInventory.builder().quantityOfBooks(bookInventoryDto.getQuantityOfBooks()).build();

    }

    public static GenreDto fromGenre(final Genre genre) {
        return GenreDto.builder().genreName(genre.getGenreName()).build();
    }

    public static Genre fromGenreDto(final GenreDto genreDto) {
        return Genre.builder().genreName(genreDto.getGenreName()).build();
    }

    public static IssuedBooksDto fromIssuedBooks(final IssuedBooks issuedBooks) {

        IssuedBooksDto issuedBooksDto = new IssuedBooksDto();

        issuedBooksDto.setIssueDate(issuedBooks.getIssueDate());
        issuedBooksDto.setUserLibraryCard(fromUserLibraryCard(issuedBooks.getUserLibraryCard()));
        issuedBooksDto.setBooks(fromBook(issuedBooks.getBooks()));

        return issuedBooksDto;

    }

    public static IssuedBooks fromIssuedBooksDto(final IssuedBooksDto issuedBooksDto) {

        return IssuedBooks.builder().issueDate(issuedBooksDto.getIssueDate()).returnDate(issuedBooksDto.getReturnDate()).build();
    }

    public static UserLibraryCardDto fromUserLibraryCard(final UserLibraryCard userLibraryCard) {

        UserLibraryCardDto userLibraryCardDto = new UserLibraryCardDto();

        userLibraryCardDto.setUser(fromUser(userLibraryCard.getUser()));

        return userLibraryCardDto;

    }

    public static UserLibraryCard fromUserLibraryCardDto(final UserLibraryCardDto userLibraryCardDto) {

        UserLibraryCard userLibraryCard= new UserLibraryCard();

        return userLibraryCard;
    }

    public static UserDto fromUser(final User user) {
        return UserDto.builder().userName(user.getUserName())
                .userEmail(user.getUserEmail()).userContactNumber(user.getUserContactNumber())
                .userPassword(user.getUserPassword()).userTotalFineAmount(user.getUserTotalFineAmount())
                .build();


    }

    public static User fromUserDto(final UserDto userDto) {

        return User.builder().userName(userDto.getUserName())
                .userContactNumber(userDto.getUserContactNumber()).userEmail(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword()).userTotalFineAmount(userDto.getUserTotalFineAmount())
                .build();
    }

    public static BookDto fromBook(final Book book) {

        BookDto bookDto = new BookDto();

        bookDto.setBookName(book.getBookName());
        bookDto.setAuthor(fromAuthor(book.getAuthor()));
        bookDto.setGenre(fromGenre(book.getGenre()));

        return bookDto;


    }

    public static Book fromBookDto(final BookDto bookDto) {

        return Book.builder().bookName(bookDto.getBookName()).build();

    }

}
