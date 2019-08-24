package com.finalassignment.bookworm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genre")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    @JsonManagedReference(value = "book-genre")
    private List<Book> books;
}