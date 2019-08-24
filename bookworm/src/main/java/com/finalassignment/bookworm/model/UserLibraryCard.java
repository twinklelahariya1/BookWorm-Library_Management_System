package com.finalassignment.bookworm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_library_card")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class UserLibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long cardId;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    Date issueDate;


    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    Date returnDate;
}
