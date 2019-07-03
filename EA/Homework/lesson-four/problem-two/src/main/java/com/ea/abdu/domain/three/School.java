package com.ea.abdu.domain.three;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Map<Long, Student> studentMap = new HashMap();


    public School(String name, String address) {
        this.name=name;
        this.address=address;
    }


    public Map<Long, Student> getStudentlist() {
        return studentMap;
    }

    public Student insert(Student student){
        return studentMap.put(student.getStudentId(), student);
    }

    //Student student  --- then  studentMap.remove(student.getStudentId());
    public Student deleted(Long studentId){
        return studentMap.remove(studentId);
    }


}
