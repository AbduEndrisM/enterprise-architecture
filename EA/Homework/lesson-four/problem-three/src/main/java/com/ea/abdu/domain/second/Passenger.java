package com.ea.abdu.domain.second;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "flights_id")
    private List<Flight> flights = new ArrayList<>();


    public Passenger(String name, String lastName) {
        this.name=name;
        this.lastName=lastName;
    }

    public boolean addFlight(Flight flight) {

        return flights.add(flight);
    }

    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }


}
