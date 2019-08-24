package com.finalassignment.bookworm.exception;

public class AdminNotFoundException extends IllegalArgumentException {
    private Long adminId;

    public AdminNotFoundException(Long adminId) {
        this.adminId = adminId;
    }
}
