package edu.mum.cs544.b.jointable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "JBook")
public class Book extends Product {

    private String title;
}
