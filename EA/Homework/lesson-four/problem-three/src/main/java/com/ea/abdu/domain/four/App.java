package com.ea.abdu.domain.four;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class App {


    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer1 = new Customer("Abdu","Edris");

        Reservation reservation1 = new Reservation(LocalDate.now());
        Reservation reservation2 = new Reservation(LocalDate.now());

        customer1.addReservation(reservation1);
        customer1.addReservation(reservation2);

        em.persist(customer1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer>customerTypedQuery = em.createQuery(" FROM Book as c WHERE c.fName LIKE 'A%' ", Customer.class);
        List<Customer>customerList = customerTypedQuery.getResultList();
        customerList.forEach(customer -> {
            System.out.println(customer.getFName() + ": "+customer.getReservationList());
        });


        em.getTransaction().commit();
        em.close();

    }

}