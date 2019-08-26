package com.finalassignment.bookworm.exception;

public class BookNotFoundException extends IllegalArgumentException {

    private Long bookId;

    public BookNotFoundException(Long bookId) {
        this.bookId = bookId;
    }
}
