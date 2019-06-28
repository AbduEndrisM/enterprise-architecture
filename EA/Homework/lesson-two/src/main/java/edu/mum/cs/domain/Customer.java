package edu.mum.cs.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Column(name="first", length=45, nullable=false)
    private String firstName;

    @Column(name="last", length=60, nullable=true)
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    private LocalDate boa;

    @Transient
    private String temp;

    @Lob
    private String biography;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, Date birthDate, LocalDate boa, String temp, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.boa = boa;
        this.temp = temp;
        this.biography = biography;
    }

}
