package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_library_card")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class UserLibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userLibraryCard")
    @JsonManagedReference(value = "issue-book-library-card")
    private List<IssuedBooks> issuedBooks;



}
