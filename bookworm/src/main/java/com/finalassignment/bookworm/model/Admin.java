package com.finalassignment.bookworm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long adminId;

    @Column(name = "admin_name")
    @Size(max = 50)
    String adminName;

    @Column(name = "contact_number")
    @NotNull
    Long adminContactNumber;

    @Column(name = "admin_email",unique = true)
    @Email
    @Size(max = 50)
    String adminEmail;

    @Column(name = "admin_password")
    @Size(max = 50)
        String adminPassword;

}