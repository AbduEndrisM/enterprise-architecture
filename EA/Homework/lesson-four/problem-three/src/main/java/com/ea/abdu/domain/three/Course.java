package com.ea.abdu.domain.three;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;
    private String courseCode;


    @ManyToMany (mappedBy = "courseList", cascade = CascadeType.PERSIST)
    List<Student> studentList = new ArrayList<>();

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public Collection<Student> getStudentlist() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
    }

