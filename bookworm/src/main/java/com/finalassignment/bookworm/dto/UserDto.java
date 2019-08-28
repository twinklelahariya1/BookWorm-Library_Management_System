package com.finalassignment.bookworm.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userName;

    private Long userContactNumber;

    private String userEmail;

    private String userPassword;

    private int userTotalFineAmount;
}
