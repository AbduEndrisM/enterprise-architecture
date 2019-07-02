package edu.mum.main;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:context/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
//
//        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();

        User user = new User("Abdu", "Edris", "abdu@mum.edu", 12, true, 1, LocalDate.now());

        userService.save(user);

        User u = userService.findByEmail("abdu@mum.edu");

        System.out.println("*************  User ***************");
        System.out.println("User Name: " + u.getFirstName() + " " + u.getLastName());


    }


}