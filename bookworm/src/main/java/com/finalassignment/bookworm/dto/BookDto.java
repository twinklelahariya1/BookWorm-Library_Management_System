package com.finalassignment.bookworm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.finalassignment.bookworm.model.Author;
import com.finalassignment.bookworm.model.Genre;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String bookName;

    private GenreDto genre;

    private AuthorDto author;
}
