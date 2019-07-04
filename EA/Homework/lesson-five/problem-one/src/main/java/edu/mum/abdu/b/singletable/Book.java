package edu.mum.cs544.b.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity(name = "SBook")
public class Book extends Product {

    private String title;
}
