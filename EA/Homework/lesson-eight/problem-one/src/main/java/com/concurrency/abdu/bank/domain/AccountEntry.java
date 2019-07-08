package com.concurrency.abdu.bank.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class AccountEntry {


    @Id
    @GeneratedValue
    private Long id;

    private Date date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;


    public AccountEntry(Date date, double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }


}
