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
public class AdminDto {

    private String adminName;

    private Long adminContactNumber;

    private String adminEmail;

    private String adminPassword;

}