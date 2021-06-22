package com.toluAdesola.myMarketPlace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "email cannot be empty")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "username cannot be empty")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "phone number cannot be empty")
    private String phoneNumber;

}
