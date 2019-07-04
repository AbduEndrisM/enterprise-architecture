package com.ea.abdu.domain.first;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public boolean addEmployee(Employee employee){
        boolean added = employeeList.add(employee);
        if (added==true){
            employee.setDepartment(this);
        }
        return added;
    }


    public boolean deleteEmployee(Employee employee){

        boolean deleted = employeeList.remove(employee);
        if (deleted){
            employee.setDepartment(null);
        }
        return deleted;
    }

}
