package com.ea.abdu.domain.second;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {


    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Publisher publisher = new Publisher("Coelho");
        Publisher publisher2 = new Publisher("Mega");
        Book book1 = new Book("The Alchemist", 123L, publisher);
        Book book2 = new Book("Veronica", 12345L, publisher);
        Book book3 = new Book("The spy", 345L, publisher);

        Book book4 = new Book("Piyassa", 12345L, publisher2);
        Book book5 = new Book("Bole", 345L, publisher2);

        em.persist(book1);
        em.persist(book2);
        em.persist(book3);
        em.persist(book4);
        em.persist(book5);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book>bookTypedQuery = em.createQuery("SELECT distinct b FROM Book  b JOIN b.publisher as p WHERE p.name =:mega", Book.class);
        bookTypedQuery.setParameter("mega", "Mega");
        List<Book>bookList = bookTypedQuery.getResultList();
        bookList.forEach(book -> {
            System.out.println(book);
        });


        em.getTransaction().commit();
        em.close();

    }

}