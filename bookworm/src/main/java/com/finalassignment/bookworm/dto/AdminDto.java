package com.finalassignment.bookworm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private Long adminId;

    private String adminName;

    private Long adminContactNumber;

    private String adminEmail;

    private String adminPassword;

}