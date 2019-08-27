package com.finalassignment.bookworm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long bookId;

    private String bookName;

    private AuthorDto author;

    private GenreDto genre;

    private List<IssuedBooksDto> issuedBooks;


}
