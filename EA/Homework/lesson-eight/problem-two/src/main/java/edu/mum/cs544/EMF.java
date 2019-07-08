package edu.mum.cs544;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("cs544");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}