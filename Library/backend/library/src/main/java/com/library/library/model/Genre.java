package com.library.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String genreName;


}
