package edu.mum.cs544.b.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "SCD")
public class CD extends Product {

    private String artist;
}
