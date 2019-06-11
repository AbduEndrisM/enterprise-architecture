package com.spring.abdu.springexam.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rating;
    private String comment;
    @ManyToOne
    private Book book;

}
