package com.finalassignment.bookworm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataValidationException extends RuntimeException {

    public DataValidationException(String exception){
        super(exception);
    }
}
