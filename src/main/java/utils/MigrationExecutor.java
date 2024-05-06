package utils;

import org.flywaydb.core.Flyway;

public class MigrationExecutor {
    public static void executeMigration(String connectionUrl, String user, String pass){
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, user, pass).load();
        flyway.migrate();
    }
}