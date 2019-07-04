package com.ea.abdu.domain.first;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data

public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String fName;
    private String lName;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
    }
}
