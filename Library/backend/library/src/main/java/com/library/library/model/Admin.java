package com.library.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String adminUsername;
    @Column
    private String adminEmail;
    @Column
    private String adminPassword;
}