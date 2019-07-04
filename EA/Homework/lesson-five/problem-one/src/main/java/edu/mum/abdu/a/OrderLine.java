package edu.mum.cs544.a;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
