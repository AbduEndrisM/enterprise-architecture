package edu.mum.cs.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
//@Setter
//@Getter
@NoArgsConstructor
@Entity
//@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
//    @Temporal should only be set on a java.util.Date or java.util.Calendar property:
//    @Temporal(TemporalType.DATE)
    private LocalDate publish_date;


    public Book(String title, String ISBN, String author, double price, LocalDate publish_date) {
        this.title=title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }
}
