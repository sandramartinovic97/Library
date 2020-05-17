package com.library.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer bookId;
    @Column
    private Integer genreId;

}
