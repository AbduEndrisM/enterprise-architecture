package com.ea.abdu.domain.second;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "departure")
    private String from;

    @Column(name = "arrival")
    private String to;

    public Flight(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
