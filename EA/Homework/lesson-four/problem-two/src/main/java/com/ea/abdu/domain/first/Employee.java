package com.ea.abdu.domain.first;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Set<Laptop> laptopSet = new HashSet<>();

    public Employee(String name, String lastName) {
        this.name=name;
        this.lastName=lastName;
    }


    public boolean addLaptop(Laptop laptop){
        boolean inserted = laptopSet.add(laptop);
        if (inserted) {
            laptop.setEmployee(this);
        }
        return inserted;
    }

    public boolean deleteLaptop(Laptop laptop){
        boolean deleted = laptopSet.remove(laptop);
        if (deleted) {
            laptop.setEmployee(null);
        }
        return deleted;
    }


    public Set<Laptop> getLaptoplist() {
        return Collections.unmodifiableSet(laptopSet);
    }

}
