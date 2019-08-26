package com.finalassignment.bookworm.exception;

public class UserLibraryCardNotFoundException extends IllegalArgumentException {
    private Long libraryCardId;

    public UserLibraryCardNotFoundException(Long libraryCardId) {
        this.libraryCardId = libraryCardId;
    }
}
