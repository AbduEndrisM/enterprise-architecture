package edu.mum.cs544;

import lombok.*;

import javax.persistence.Embeddable;


@ToString
@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Payment {

    private String paydate;
    private double amount;

    public Payment(String paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }

}
