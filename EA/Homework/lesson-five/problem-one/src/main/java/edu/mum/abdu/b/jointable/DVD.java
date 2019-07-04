package edu.mum.cs544.b.jointable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "JDVD")
public class DVD extends Product {

    private String genre;
}
