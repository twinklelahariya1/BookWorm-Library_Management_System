package com.finalassignment.bookworm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssuedBooksDto {

    private Long issueId;

    private LocalDate issueDate;

    private LocalDate returnDate;

    private BookDto books;

    private UserLibraryCardDto userLibraryCard;

}