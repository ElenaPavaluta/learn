//package oc.p.chapters._10_.introducingRelationalDatabasesAndSQL.identifyingTheStructureOfARelationalDatabase;
//
//import books.thinkigInJava._4ThEdition.chapters.annotations.generatingExternalFiles.DBTable;
//import utils.resources.db.dbInstance.ZooDbInstance;
//import utils.resources.files.Resources;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//class SetupDerbyDatabase {
//
//
//    static String url = ZooDbInstance.url  + ";create=true";
//
//    static void m() {
////        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
//
//        try(Connection conn = DriverManager.getConnection(url);
//            Statement stmt = conn.createStatement()) {
//
//            stmt.executeUpdate("CREATE TABLE species (" +
//                                       "id INTEGER PRIMARY KEY," +
//                                       "name VARCHAR(255)," +
//                                       "num_acres DECIMAL)");
//
//            stmt.executeUpdate("CREATE TABLE animal (" +
//                                       "id INTEGER PRIMARY KEY," +
//                                       "species_id INTEGER, " +
//                                       "name VARCHAR(255)," +
//                                       "date_born TIMESTAMP)");
//
//            stmt.executeUpdate("INSERT INTO species VALUES (" +
//                                       "1, 'African Elephant', 7.5)");
//            stmt.executeUpdate("INSERT INTO species VALUES (" +
//                                       "2, 'Zebra', 1.2)");
//
//            stmt.executeUpdate("INSERT INTO animal VALUES (" +
//                                       "1, 2, 'Elsa', TIMESTAMP('2001-05-06 02:15:00'))");
//            stmt.executeUpdate("INSERT INTO animal VALUES (" +
//                                       "2, 2, 'Zelda', TIMESTAMP('2002-05-06 02:15:00'))");
//            stmt.executeUpdate("INSERT INTO animal VALUES (" +
//                                       "3, 1, 'Ester', TIMESTAMP('2003-05-06 02:15:00'))");
//            stmt.executeUpdate("INSERT INTO animal VALUES (" +
//                                       "4, 1, 'Eddie', TIMESTAMP('2004-05-06 02:15:00'))");
//            stmt.executeUpdate("INSERT INTO animal VALUES (" +
//                                       "5, 2, 'Zoe', TIMESTAMP('2005-05-06 02:15:00'))");
//
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        m();
//    }
//}
