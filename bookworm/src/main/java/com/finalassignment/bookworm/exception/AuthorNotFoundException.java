package com.finalassignment.bookworm.exception;

public class AuthorNotFoundException extends IllegalArgumentException {
    private Long authorId;

    public AuthorNotFoundException(Long authorId) {
        this.authorId = authorId;
    }
}