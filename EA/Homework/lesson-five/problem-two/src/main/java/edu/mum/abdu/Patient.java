package edu.mum.cs544;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@SecondaryTable(name="Address", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "id")
})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(table = "Address")
    private String street;

    @Column(table = "Address")
    private String zip;

    @Column(table = "Address")
    private String city;

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
