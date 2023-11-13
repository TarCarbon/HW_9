package org.example.db;

import org.flywaydb.core.Flyway;

public class FlywayMigration {

    public static void migration(){
        Flyway.configure().dataSource()
                .load().migrate();
    }
}
