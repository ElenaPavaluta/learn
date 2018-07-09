package utils.resources.db.instance.embedded.derby;

import utils.resources.db.DbDefinition;
import utils.resources.db.DbInstance;
import java.sql.SQLException;
import java.sql.Statement;

public class ZooDb extends DbInstance {

    private static volatile ZooDb instance;

    private ZooDb(DbDefinition def) {
        super(def);
    }

    public static synchronized ZooDb dbInstance(DbDefinition def) {
        if(instance == null) {
            synchronized(ZooDb.class) {
                instance = new ZooDb(def);
            }
        }
        return instance;
    }


    @Override
    protected void createAndPopulateTables(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE TABLE species (" +
                                   "id INTEGER PRIMARY KEY," +
                                   "name VARCHAR(255)," +
                                   "num_acres DECIMAL)");

        stmt.executeUpdate("CREATE TABLE animal (" +
                                   "id INTEGER PRIMARY KEY," +
                                   "species_id INTEGER, " +
                                   "name VARCHAR(255)," +
                                   "date_born TIMESTAMP)");

        stmt.executeUpdate("INSERT INTO species VALUES (" +
                                   "1, 'African Elephant', 7.5)");
        stmt.executeUpdate("INSERT INTO species VALUES (" +
                                   "2, 'Zebra', 1.2)");

        stmt.executeUpdate("INSERT INTO animal VALUES (" +
                                   "1, 2, 'Elsa', TIMESTAMP('2001-05-06 02:15:00'))");
        stmt.executeUpdate("INSERT INTO animal VALUES (" +
                                   "2, 2, 'Zelda', TIMESTAMP('2002-05-06 02:15:00'))");
        stmt.executeUpdate("INSERT INTO animal VALUES (" +
                                   "3, 1, 'Ester', TIMESTAMP('2003-05-06 02:15:00'))");
        stmt.executeUpdate("INSERT INTO animal VALUES (" +
                                   "4, 1, 'Eddie', TIMESTAMP('2004-05-06 02:15:00'))");
        stmt.executeUpdate("INSERT INTO animal VALUES (" +
                                   "5, 2, 'Zoe', TIMESTAMP('2005-05-06 02:15:00'))");
    }
}
