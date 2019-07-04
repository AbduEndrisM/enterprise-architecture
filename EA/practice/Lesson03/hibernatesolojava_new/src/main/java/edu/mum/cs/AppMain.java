package edu.mum.cs;

import edu.mum.cs.domain.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the Person object
            Person p = new Person("Aaron James");
            p.setId(1L);
            System.out.println("1");
            session.save(p);
            System.out.println("2");
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
