package com.finalassignment.bookworm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.finalassignment.bookworm.model.Book;
import com.finalassignment.bookworm.model.UserLibraryCard;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuedBooksDto {

    private LocalDate issueDate;

    private LocalDate returnDate;

    private BookDto books;

    private UserLibraryCardDto userLibraryCard;

}