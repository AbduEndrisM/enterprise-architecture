package com.ea.abdu.domain.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.security.acl.Owner;
import java.util.List;

public class App {

        private static EntityManagerFactory emf;
        public static void main(String[] args) throws Exception {

            emf = Persistence.createEntityManagerFactory("lesson-four");

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            // Create new instance of Car and set values in it
            Employee employee1 = new Employee("Abdu", "Edris");
            Employee employee2 = new Employee("Jado", "Jean");
            Employee employee3 = new Employee("Tina", "Xing");

            Laptop laptop1 = new Laptop( "Asus", 700.0);
            Laptop laptop2 = new Laptop( "Macbook Pro", 1000.0);
            Laptop laptop3 = new Laptop( "hp", 600.0);

            employee1.addLaptop(laptop1);
            employee1.addLaptop(laptop2);

            employee2.addLaptop(laptop2);
            employee1.addLaptop(laptop3);


            // save  employees
            em.persist(employee1);
            em.persist(employee2);
            em.persist(employee3);

            em.getTransaction().commit();
            em.close();

            em = emf.createEntityManager();
            em.getTransaction().begin();

            TypedQuery<Employee>employeeTypedQuery=em.createQuery("FROM Employee", Employee.class);
            TypedQuery<Laptop>laptopTypedQuery=em.createQuery("FROM Laptop", Laptop.class);

            List<Employee>employeeList=employeeTypedQuery.getResultList();

            List<Laptop>laptopList=laptopTypedQuery.getResultList();

            //Employees detail
            employeeList.forEach(employee -> {
                employee.getLaptoplist().forEach(laptop -> {
                    System.out.println("EMployee Detail"+ employee.getName()+" "+ employee.getLastName()+" Laptops: "+
                            laptop.getBrand() );
                });
            });

            //Laptops Detail
            laptopList.forEach(laptop -> {
                employeeList.forEach(employee -> {
                    System.out.println("Laptop detail: "+ laptop.getBrand()+" Employee list: "+ employee.getName()+" "+
                            employee.getLastName());
                });
            });

    }
}
