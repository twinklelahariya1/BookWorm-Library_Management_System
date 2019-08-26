package com.finalassignment.bookworm.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long authorId;

    @Column(name = "author_name")
    @Size(max = 50)
    private String authorName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    @JsonManagedReference(value = "book-author")
    private List<Book> books;
}
