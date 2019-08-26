package com.finalassignment.bookworm.exception;

public class IssueBookNotFoundException extends IllegalArgumentException {
    private Long issueBookId;

    public IssueBookNotFoundException(Long issueId) {
        this.issueBookId = issueBookId;
    }
}
