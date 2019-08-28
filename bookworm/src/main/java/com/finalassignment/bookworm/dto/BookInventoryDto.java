package com.finalassignment.bookworm.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInventoryDto {

    private Long quantityOfBooks;

    private BookDto book;
}
