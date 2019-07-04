package edu.mum.cs544.b.jointable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="JCustomer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Collection<Order> orders = new ArrayList<>();

    public boolean addOrder(Order o) {
        boolean added = orders.add(o);
        if (added) {
            o.setCustomer(this);
        }
        return added;
    }

}
