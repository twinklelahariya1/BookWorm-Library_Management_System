package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "genre")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long genreId;

    @Column(name = "genre_name")
    @Size(max = 50)
    private String genreName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    @JsonManagedReference(value = "book-genre")
    private List<Book> books;
}