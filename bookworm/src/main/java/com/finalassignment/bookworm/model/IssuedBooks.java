package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issued_books")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class IssuedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long issueId;

    @Column(name = "issue_date")
    @NotNull
    private LocalDate issueDate;

    @Column(name = "return_date")
    @Nullable
    private LocalDate returnDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-issue-book")
    private Book books;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_card_id")
    @JsonBackReference(value = "issue-book-library-card")
    private UserLibraryCard userLibraryCard;

}