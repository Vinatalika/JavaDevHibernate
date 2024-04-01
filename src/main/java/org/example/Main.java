package org.example;

import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        DatabaseInit databaseInit = new DatabaseInit();
        databaseInit.initDb("jdbc:h2:./test", "sa", "");

        HibernateUtils hibernateUtils = HibernateUtils.getInstance();
        SessionFactory sessionFactory = hibernateUtils.getSessionFactory();


    }
}