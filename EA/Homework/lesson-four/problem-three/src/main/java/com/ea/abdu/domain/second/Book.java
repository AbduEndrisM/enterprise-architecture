package com.ea.abdu.domain.second;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Long ISBN;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Publisher publisher;

    public Book(String title, Long ISBN, Publisher publisher) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher=publisher;
    }

}
