package edu.mum.cs544.b.jointable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "JCD")
public class CD extends Product {

    private String artist;
}
