package com.finalassignment.bookworm.dto;

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
public class UserLibraryCardDto {

    private Long cardId;

    private UserDto user;

    private List<IssuedBooksDto> issuedBooks;



}
