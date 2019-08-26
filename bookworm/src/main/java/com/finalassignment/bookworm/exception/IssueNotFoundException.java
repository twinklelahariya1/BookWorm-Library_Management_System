package com.finalassignment.bookworm.exception;

public class IssueNotFoundException extends IllegalArgumentException {
    private Long issueId;

    public IssueNotFoundException(Long issueId) {
        this.issueId = issueId;
    }
}
