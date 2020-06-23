package com.library.library.model;
import com.library.library.model.Role;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    private String customerName;
    @Column()
    private String customerSurname;
    @Column()
    private String customerUsername;
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
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}

