package com.library.library.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer Id;
    @Column()
    private String customerSurname;
    @Column()
    private String customerGender;
    @Column()
    private String customerPhoneNum;
    @Column()
    private String customerEmail;
    @Column()
    private String customerCountry;
    @Column()
    private String customerCity;
    @Column()
    private String customerStreet;
    @Column()
    private String customerPassword;

}
