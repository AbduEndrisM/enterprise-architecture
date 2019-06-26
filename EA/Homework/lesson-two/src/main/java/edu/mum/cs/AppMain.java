package edu.mum.cs;

import edu.mum.cs.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer c = new Customer("Jack", "Welsh");
        em.persist(c);

        Customer c2 = new Customer("Tina", "Xing", new Date(), LocalDate.of(1999, 11, 12), "This won't be saved", "Teaching in MUM.");
        em.persist(c2);

        em.getTransaction().commit();
        em.getTransaction().begin();
        TypedQuery<Customer> q = em.createQuery("from Customer", Customer.class);
        List<Customer> customers = q.getResultList();

        for (Customer cust : customers) {
            System.out.println(cust.getFirstName() + " " + cust.getLastName());
        }

        em.getTransaction().commit();
        emf.close();
    }

}
