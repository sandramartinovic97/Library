
package com.library.library.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Clob;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String bookName;
    @Column
    private String bookAuthor;
    @Column
    private String bookDescription;
    @Column
    private String bookPublisher;
    @Column
    private String bookLanguage;
    @Column
    private Integer bookYear;
    @Column
    private Double bookPrice;
    @Column
    private Integer bookQuantity;
    @Column
    @Lob
    private String bookCover;

}

