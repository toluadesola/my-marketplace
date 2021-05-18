package com.example.week8tasktoluadesola.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="mails")
@NoArgsConstructor
@AllArgsConstructor
public class SendMail {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String subject;
    private String text;
    private Long companyId;

    Timestamp created_at =  new Timestamp(System.currentTimeMillis());
}
