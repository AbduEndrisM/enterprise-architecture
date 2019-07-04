package com.ea.abdu.domain.six;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String fName;
    private String lName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Office office;

    public Employee(String fName, String lName, Office office) {
        this.fName = fName;
        this.lName = lName;
        this.office = office;
    }




}
