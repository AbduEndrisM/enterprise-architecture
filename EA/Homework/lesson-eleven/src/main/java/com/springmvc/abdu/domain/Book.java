package com.springmvc.abdu.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class Book {

    @Id
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;



}
