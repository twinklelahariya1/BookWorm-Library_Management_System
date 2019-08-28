package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.finalassignment.bookworm.dto.AuthorDto;
import com.finalassignment.bookworm.dto.GenreDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name")
    @Size(max = 60)
    private String bookName;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_Id")
    @JsonBackReference(value = "book-author")
    private Author author;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_Id")
    @JsonBackReference(value = "book-genre")
    private Genre genre;


    @OneToMany(mappedBy = "books")
    @JsonManagedReference(value = "book-issue-book")
    private List<IssuedBooks> issuedBooks;


}
