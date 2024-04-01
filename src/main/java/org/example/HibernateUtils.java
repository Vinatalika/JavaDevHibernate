package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE = new HibernateUtils();
    private final SessionFactory sessionFactory;

    private HibernateUtils() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
