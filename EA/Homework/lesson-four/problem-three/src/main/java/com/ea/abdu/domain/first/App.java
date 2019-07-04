package com.ea.abdu.domain.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department1 = new Department("CS");
        Department department2 = new Department("Acca");
        Department department3 = new Department("Comp");

        Employee employee1 = new Employee("Abdu", "Edris");
        Employee employee2 = new Employee("Sobah", "Edris");
        Employee employee3 = new Employee("Semira", "Edris");
        Employee employee4 = new Employee("Jado", "Edris");

        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department2.addEmployee(employee3);
        department3.addEmployee(employee4);
        department3.addEmployee(employee1);

        em.persist(department1);
        em.persist(department2);
        em.persist(department3);


        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Department> departmentTypedQuery = (TypedQuery<Department>) em.createQuery("FROM Department", Department.class);
        List<Department> departmentList = departmentTypedQuery.getResultList();

        departmentList.forEach(department -> {
            System.out.println("Department: "+ department.getName());
            department.getEmployeeList().forEach(employee -> {
                System.out.println(" Professors : "+employee.getFName());
            });
        });


        em.getTransaction().commit();
        em.close();




    }
    }
