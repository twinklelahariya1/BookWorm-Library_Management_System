package com.finalassignment.bookworm.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long adminId;

    @Column(name = "admin_name")
    @Size(max = 50)
    private String adminName;

    @Column(name = "contact_number")
    @NotNull
    private Long adminContactNumber;

    @Column(name = "admin_email",unique = true)
    @Email
    @Size(max = 50)
    private String adminEmail;

    @Column(name = "admin_password")
    @Size(max = 50)
    private String adminPassword;

}