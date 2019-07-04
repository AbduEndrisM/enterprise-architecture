package com.ea.abdu.domain.six;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String officeNo;

    @OneToMany(mappedBy = "office")
    List<Employee>employeeList = new ArrayList<>();

    public Office(String fName, String officeNo) {
        this.fName = fName;
        this.officeNo = officeNo;
    }
}
