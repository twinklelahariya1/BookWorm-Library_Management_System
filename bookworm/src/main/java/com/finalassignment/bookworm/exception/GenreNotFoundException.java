package com.finalassignment.bookworm.exception;

public class GenreNotFoundException extends IllegalArgumentException {
    private Long genreId;
    public GenreNotFoundException(Long genreId) {
        this.genreId=genreId;
    }
}
