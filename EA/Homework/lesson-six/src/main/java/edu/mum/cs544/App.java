package edu.mum.cs544;

import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        TypedQuery<Flight>flightListFlightTypedQuery = em.createQuery(" select distinct f FROM Flight f " +
                "JOIN  f.origin as o JOIN f.airplane as a WHERE o.country='USA' AND a.capacity> 500 ", Flight.class);
List<Flight>flightList = flightListFlightTypedQuery.getResultList();

        List<Flight> flights = em.createQuery("from Flight ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for(Flight f:flightList){
            System.out.println(f.getFlightnr()+ ": " + ": "+ f.getDepartureDate()+": "+f.getOrigin()+": "+f.getDestination()+": "+f.getAirplane().getCapacity());
        }
//        for (Flight flight : flights) {
//            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
//                    flight.getFlightnr(), flight.getOrigin().getCity(),
//                    flight.getDepartureDate(), flight.getDepartureTime(),
//                    flight.getDestination().getCity(),
//                    flight.getArrivalDate(), flight.getArrivalTime());
//        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        List<Airline> airlines = em.createQuery("from Airline ", Airline.class).getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flights = em.createQuery("from Flight ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("from Flight ", Flight.class);
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();
    }
}
