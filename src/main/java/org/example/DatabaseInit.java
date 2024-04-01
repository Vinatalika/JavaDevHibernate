package org.example;

import org.flywaydb.core.Flyway;

public class DatabaseInit {

    public void initDb(String connectionUrl, String username, String password) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, username, password)
                .locations("filesystem:src/main/resources/db")
                .load();
        flyway.migrate();
    }
}