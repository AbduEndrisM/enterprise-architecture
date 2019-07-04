package com.ea.abdu.domain.three;

import com.ea.abdu.domain.second.Book;
import com.ea.abdu.domain.second.Publisher;

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

        Student student1 = new Student("Abdu","Edris");
        Student student2 = new Student("Sobah","Edris");
        Course course1 = new Course("CS544", "EA");
        Course course2 = new Course("CS545", "WAA");

        course1.addStudent(student1);
        course1.addStudent(student2);

        course2.addStudent(student2);

        em.persist(course1);
        em.persist(course2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Course>courseTypedQuery = em.createQuery(" FROM Reservation ", Course.class);
        List<Course>courseList = courseTypedQuery.getResultList();
        courseList.forEach(course -> {
            System.out.println(course);
        });


        em.getTransaction().commit();
        em.close();

    }

}