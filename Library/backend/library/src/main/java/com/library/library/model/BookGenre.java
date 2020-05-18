package com.library.library.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

}
