package com.ea.abdu.domain.five;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class App {


    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("The Alchemist","123456");

        Reservation reservation1 = new Reservation(LocalDate.now(), book1);
        Reservation reservation2 = new Reservation(LocalDate.now(),book1);

        em.persist(reservation1);
        em.persist(reservation2);

        em.getTransaction().commit();
        em.close();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Reservation>reservationTypedQuery = em.createQuery(" FROM Reserv ",Reservation.class);
        List<Reservation> resultList = reservationTypedQuery.getResultList();
        resultList.forEach(reservation -> {
            System.out.println(reservation.getBook().getTitle());
        });


        em.getTransaction().commit();
        em.close();

    }

}