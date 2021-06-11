package com.toluAdesola.myMarketPlace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company {



    @Id
    @GeneratedValue
    private Long id;

    private String companyName;
    private String roleInCompany;
    private String description;
    private String companyEmail;
    private String companyPhoneNumber;
    private String companyAddress;
    private String industryType;
    private String companyWebsite;
    private String numberOfEmployees;
    private String state;
    private String lga;
    private String city;
    private String facebook;
    private String twitter;
    private String google;
    private String instagram;
    private String linkedIn;
    private String isPopular;

    private String images;

    @OneToOne
    private User user;
    @OneToMany
    List<SendMail> sendMail;
}
