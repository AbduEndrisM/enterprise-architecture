package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentDAO {

    public Student load(long studentid) {
        EntityManager em = EntityManagerHelper.getCurrent();
        EntityGraph<Student> studentEntityGraph = em.createEntityGraph(Student.class);
        studentEntityGraph.addAttributeNodes("courselist");

//        TypedQuery<Student> query = em.createQuery("from Student s where s.studentid = :sid", Student.class);
        TypedQuery<Student> query = em.createQuery("from Student where studentid = :sid", Student.class);
        query.setParameter("sid", studentid);
        query.setHint("javax.persistence.fetchgraph", studentEntityGraph);
        return query.getSingleResult();
    }
}
