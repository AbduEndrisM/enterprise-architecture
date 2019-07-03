package com.ea.abdu.domain.second;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.security.acl.Owner;
import java.util.Collection;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Passenger abdu = new Passenger("Abdu", "Edris");
        Flight flight1 = new Flight("Addis", "Istanbul");
        Flight flight2 = new Flight("Istanbul", "Frankfurt");
        Flight flight3 = new Flight("Frankfurt", "Chicago");

        abdu.addFlight(flight1);
        abdu.addFlight(flight2);
        abdu.addFlight(flight3);

        // save  passenger
        em.persist(abdu);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Passenger> typedQuery = em.createQuery("FROM Passenger", Passenger.class);
        List<Passenger> resultList = typedQuery.getResultList();

        resultList.forEach(passenger -> {
            passenger.getFlights().forEach(flight -> {
                System.out.println("Name " + passenger.getName() + " " + passenger.getLastName() + "  is going  "
                        + flight.getFrom() + " to " + flight.getTo());

            });
        });
    }
}
