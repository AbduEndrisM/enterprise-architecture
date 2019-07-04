package com.ea.abdu.domain.six;

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


        Office office1 = new Office("CS", "123");
        Office office2 = new Office("MSCS", "111");

        Employee employee1 = new Employee("Abdu", "Edris", office1);
        Employee employee2 = new Employee("Sobah", "Edris",office2);
        Employee employee3 = new Employee("Semira", "Edris",office1);
        Employee employee4 = new Employee("Jado", "Edris",office1);


        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<String> officeTypedQuery =  em.createQuery("select e.fName FROM Office o  JOIN o.employeeList as e" +
                " WHERE e.office.officeNo='111'  ", String.class);
        List<String> employeeList = officeTypedQuery.getResultList();

        employeeList.forEach(
        System.out::println
                );


        em.getTransaction().commit();
        em.close();




    }
    }
