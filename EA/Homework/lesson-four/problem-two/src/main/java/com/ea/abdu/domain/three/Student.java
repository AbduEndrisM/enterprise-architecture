package com.ea.abdu.domain.three;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    private Long studentId;

    private String fName;

    private String lName;

    public Student(Long studentId, String fName, String lName) {
        this.studentId=studentId;
        this.fName=fName;
        this.lName=lName;
    }


}
