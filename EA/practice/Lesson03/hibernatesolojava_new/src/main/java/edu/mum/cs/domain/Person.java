package edu.mum.cs.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.StringTokenizer;

@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //Uncomment this to see the Hibernate hold the object in cache
    private Long id;
    private String name;

    public Person(String name){
        this.name = name;
    }
}

