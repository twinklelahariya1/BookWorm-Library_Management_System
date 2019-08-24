package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_Id")
    @JsonBackReference(value = "book-author")
    private Author author;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_Id")
    @JsonBackReference(value = "book-genre")
    private Genre genre;


    @Column(name = "quantity_of_book")
    private Long quantityOfBooksAvailableInLibrary;


}
