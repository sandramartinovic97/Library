package com.library.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date orderDate;
    @Column
    private String orderStatus;
    @Column
    private Double orderPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
