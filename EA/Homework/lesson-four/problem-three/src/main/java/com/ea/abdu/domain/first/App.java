package com.ea.abdu.domain.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department1 = new Department("CS");
        Department department2 = new Department("Acca");
        Department department3 = new Department("Comp");
        Department department4 = new Department("MSCS");

        Employee employee1 = new Employee("Abdu", "Edris", department1);
        Employee employee2 = new Employee("Sobah", "Edris", department2);
        Employee employee3 = new Employee("Semira", "Edris", department3);
        Employee employee4 = new Employee("Jado", "Edris", department4);


        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(employee4);


    }
    }
