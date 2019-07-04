package com.ea.abdu.domain.three;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Stu")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;

    @ManyToMany
    @JoinTable
    List<Course>courseList = new ArrayList<>();

    public Student(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }


    public boolean addCourse(Course course) {
            boolean added = courseList.add(course);
            if (added){
                course.getStudentlist().add(this);
            }

            return added;
    }

    public  boolean deleteCourse(Course course){
        boolean delete= courseList.remove(course);
        if (delete){
            course.getStudentlist().add(null);
        }
        return delete;
    }
}
