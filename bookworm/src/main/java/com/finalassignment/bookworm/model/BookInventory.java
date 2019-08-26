package com.finalassignment.bookworm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventory")
public class BookInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long inventoryId;

    @Column(name = "quantity_of_books")
    @Min(0)
    @Max(5)
    private Long quantityOfBooks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
}
