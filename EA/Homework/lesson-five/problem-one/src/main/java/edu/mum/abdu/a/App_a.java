package edu.mum.abdu.a.;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

public class App_a {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Product book = new Product("Hibernate 3", "Good book on Hibernate");
        OrderLine ol1 = new OrderLine(2, book);

        Product cd = new Product();
        cd.setName("The best of Queen");
        cd.setDescription("Album from 1995");
        OrderLine ol2 = new OrderLine(4, cd);

        Order o1 = new Order("234743", LocalDateTime.now());
        o1.addOrderLine(ol1);
        o1.addOrderLine(ol2);

        Customer c1 = new Customer("Frank", "Brown");
        c1.addOrder(o1);

        // save the customer -- cascades down
        em.persist(c1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all orders
        @SuppressWarnings("unchecked")
        List<Order> orderList = em.createQuery("from Order").getResultList();
        for (Order order : orderList) {
            printOrder(order);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void printOrder(Order order) {
        System.out.println("Order with orderNumber: " + order.getOrderid());
        System.out.println("Order date: " + order.getDateTime());

        Customer cust = order.getCustomer();
        System.out.println("Customer: " + cust.getFirstname() + " "
                + cust.getLastname());
        for (OrderLine orderline : order.getOrderLineList()) {
            System.out.println("Order line: quantity= "
                    + orderline.getQuantity());
            Product product = orderline.getProduct();
            System.out.println("Product: " + product.getName() + " "
                    + product.getDescription());

        }
    }
}
