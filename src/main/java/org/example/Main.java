package org.example;

import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        //Ініціалізація за допомогою flyway
        DatabaseInit databaseInit = new DatabaseInit();
        databaseInit.initDb("jdbc:h2:./test", "sa", "");
        // Ініціалізація Hibernate
        HibernateUtils hibernateUtils = HibernateUtils.getInstance();
        SessionFactory sessionFactory = hibernateUtils.getSessionFactory();


    }
}