package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Doctor doctor1 = new Doctor("Chirurg", "Frank", "Brown");
        Doctor doctor2 = new Doctor("Nurse", "Mary", "Jones");

        Payment payment1 = new Payment("10-10-2008", 12.50);
        Payment payment2 = new Payment("11-10-2008", 45.00);
        Payment payment3 = new Payment("12-10-2008", 99.60);
        Payment payment4 = new Payment("13-10-2008", 55.80);

        Patient patient1 = new Patient("Jerry Lewis", "34 4th avenue",
                "13221", "New York");
        Patient patient2 = new Patient("Frank Moore", "34 Mainstret",
                "13221", "New York");
        Patient patient3 = new Patient("Sam ruby", "105 N Street", "13221",
                "New York");

        Appointment appointment1 = new Appointment("11-11-2008", patient1,
                payment1, doctor1);
        Appointment appointment2 = new Appointment("12-11-2008", patient2,
                payment2, doctor2);
        Appointment appointment3 = new Appointment("13-11-2008", patient3,
                payment3, doctor2);
        Appointment appointment4 = new Appointment("14-11-2008", patient1,
                payment4, doctor1);

        em.persist(appointment1);
        em.persist(appointment2);
        em.persist(appointment3);
        em.persist(appointment4);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();


        TypedQuery<Appointment> appointmentTypedQuery = em.createQuery("from Appointment", Appointment.class);
        List<Appointment> appointmentList = appointmentTypedQuery.getResultList();

        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);
        }

        em.getTransaction().commit();
        em.close();
    }

}
