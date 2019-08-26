package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issued_books")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class IssuedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    Long issueId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-issue-book")
    private Book books;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_card_id")
    @JsonBackReference(value = "issue-book-library-card")
    private UserLibraryCard userLibraryCard;

}