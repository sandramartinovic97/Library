package com.library.library.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FavouriteBook {
    @Id
    @GeneratedValue
    private Integer favouriteBookId;
    @Column()
    private Integer bookId;
    @Column()
    private Integer customerId;

}
