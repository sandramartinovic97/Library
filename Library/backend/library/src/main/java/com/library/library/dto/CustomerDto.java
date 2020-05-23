package com.library.library.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private Integer id;

    private String customerName;
    private String customerSurname;
    private String customerGender;
    private String customerPhoneNum;
    private String customerEmail;
    private String customerCountry;
    private String customerCity;
    private String customerStreet;
    private String customerPassword;
}
