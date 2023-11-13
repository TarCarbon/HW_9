package org.example.db;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

public class FlywayMigration {

    final private static Logger logger = Logger.getLogger(FlywayMigration.class);
    public static void migration(){
        try {
            Flyway.configure().dataSource("jdbc:h2:~/db/db", "user", "password")
                    .load().migrate();
            logger.info("migration is successful");
        } catch (Exception e) {
            logger.error("Migration fatal: " + e);
        }
    }
}
