package edu.mum.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lesson-four");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "M3", 30221.00);
        Owner owner1 = new Owner("Abdu", "Addis, Ethio");

        car1.setOwner(owner1);

        // save  car1
        em.persist(car1);

        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        Owner owner2 = new Owner("Tina", "Beijing, China");
        car2.setOwner(owner2);

        // save car2
        em.persist(car2);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
/*
        for (Car car : carList) {
            System.out.println("Brand= " + car.getBrand() + ", Year= "
                    + car.getYear() + ", price= " + car.getPrice() + ", Owner="+car.getOwner().getName());
        }
        */
        carList.forEach(car->{
            System.out.println("Brand= " + car.getBrand() + ", Year= " + car.getYear() + ", price= " + car.getPrice() +
                    ", Owner Name= "+car.getOwner().getName() + ", Owner Address=  "+car.getOwner().getAddress());
        });

        em.getTransaction().commit();
        em.close();
    }
}

