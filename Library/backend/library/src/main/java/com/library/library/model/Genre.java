package com.library.library.model;

import javax.persistence.*;

@Entity
public class Genre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String genreName;
}
