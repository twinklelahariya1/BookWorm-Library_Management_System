package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_Id")
    @JsonBackReference
    @JsonIgnore
    private Author author;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_Id")
    @JsonBackReference
    @JsonIgnore
    private Genre genre;


    @Column(name = "quantity_of_book")
    private Long quantityOfBooksAvailableInLibrary;


}
