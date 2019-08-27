package com.finalassignment.bookworm.dto;

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
public class BookInventoryDto {

    private Long inventoryId;

    private Long quantityOfBooks;

    private BookDto book;
}
