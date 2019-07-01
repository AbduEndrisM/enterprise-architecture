package edu.mum.cs;

import edu.mum.cs.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");



        System.out.println("====================#1=====================");
        //persist 3 books
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("The Alchemist", "123456", "Paulo Coelho", 12.5,  LocalDate.now());
        Book book2 = new Book("Brida", "2345678", "Paulo Coelho", 8.5,  LocalDate.now());
        Book book3 = new Book("Veronika Decides to Die", "456789", "Paulo Coelho", 10.5,  LocalDate.now());

        em.persist(book1);
        em.persist(book2);
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        System.out.println("====================#2=====================");
        // retieve all books
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book>bookTypedQuery=em.createQuery("from Book", Book.class);
        List<Book>books = bookTypedQuery.getResultList();
        books.forEach(book-> {
            System.out.println(book);
            });
        //book1, 2 and 3 are in PC manged life cycle so can get them without commit (hitting the DB
        //em.getTransaction().commit();
        em.close();


        System.out.println("====================#3=====================");

        //Change the title and price  and remove one book --- will be removed from entity manager on commit
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book>typedQuery = em.createQuery("from Book", Book.class);
        List<Book>bookList = typedQuery.getResultList();
        System.out.println("-----b4 -----");
        bookList.forEach(System.out::println);

        Book b = bookList.get(0);
        b.setTitle("Adultery");
        b.setPrice(20.0);
        em.persist(b);
        em.remove(bookList.get(2));

        em.getTransaction().commit();
        em.close();


        System.out.println("=============================#4=======================");
        //Retrive all book3 is deleted
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book>bookQuery = em.createQuery("from Book", Book.class);
        List<Book>bookListLast = bookQuery.getResultList();
        bookListLast.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();


    }

}
