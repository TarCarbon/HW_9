package org.example.db;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public static void migration(){
        Flyway.configure().dataSource("jdbc:h2:~/db/db", "user", "password")
                .load().migrate();
    }
}
