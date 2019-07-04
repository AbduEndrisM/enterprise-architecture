package com.ea.abdu.domain.four;

import com.ea.abdu.domain.three.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    List<Reservation>reservationList = new ArrayList<>();


    public Customer(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }


    public boolean addReservation(Reservation reservation) {
        return reservationList.add(reservation);
    }

    public  boolean deleteReservation(Reservation reservation){
        return reservationList.remove(reservation);
    }
}
