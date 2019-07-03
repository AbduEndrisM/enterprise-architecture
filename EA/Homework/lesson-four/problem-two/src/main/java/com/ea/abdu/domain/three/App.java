package com.ea.abdu.domain.three;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        School mum = new School("MUM", "Fairfield, IA, USA");
        Student student1 = new Student(11L, "Abdu", "Edris");
        Student student2 = new Student(22L, "Tina", "Edris");
        Student student3 = new Student(33L, "Jado", "Edris");

        mum.insert(student1);
        mum.insert(student2);
        mum.insert(student3);

        // save  school
        em.persist(mum);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<School> typedQuery = em.createQuery("FROM School", School.class);
        List<School> resultList = typedQuery.getResultList();

        for (School school : resultList) {
            for (Map.Entry<Long, Student> student : school.getStudentlist().entrySet()) {
                System.out.println("School Name " + school.getName() + " \n Students: " + student.getKey() + "  Student Name  "+
                        student.getValue().getFName() + " "+ student.getValue().getLName());
            }

        }
        em.getTransaction().commit();
        em.close();
    }
}
