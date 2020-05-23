package com.library.library.dto;

import lombok.Data;

import java.sql.Clob;

@Data
public class BookDto {
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookPublisher;
    private String bookLanguage;
    private Integer bookYear;
    private Double bookPrice;
    private Integer bookQuantity;
    private String bookCover;
}
