package oc.p.chapters._10_.introducingTheInterfacesOfJdbc;

import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

/**
 * Driver: Knows how to get a connection to the database
 *
 * Connection: Knows how to communicate with the database
 *
 * Statement: Knows how to run the SQL
 *
 * ResultSet: Knows what was returned by a SELECT query
 */
class Interfaces {

    static Driver DRIVER;
    static Connection CONNECTION;
    static Statement STATEMENT;
    static ResultSet RESULTSET;

    static void m() {
//        DRIVER = new EmbeddedDriver();
        try(Connection connection = DriverManager.getConnection(Dbs.ZOO.url());
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SPECIES");
            Print.print(resultSet);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
