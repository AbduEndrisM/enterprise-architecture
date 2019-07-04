package com.ea.abdu.domain.five;

import com.ea.abdu.domain.four.Reservation;
import com.ea.abdu.domain.three.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String ISBN;

    public Book(String title, String isbn) {
        this.title = title;
        this.ISBN = isbn;
    }


}
