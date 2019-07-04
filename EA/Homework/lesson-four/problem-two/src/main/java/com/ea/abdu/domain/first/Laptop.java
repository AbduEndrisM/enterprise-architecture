package com.ea.abdu.domain.first;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private double price;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
}
