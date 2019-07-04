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
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String appdate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient")
    private Patient patient;

    @Embedded
    private Payment payment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }
}
