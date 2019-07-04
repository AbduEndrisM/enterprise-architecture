package edu.mum.cs544.b.singletable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "SOrderLine")
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
