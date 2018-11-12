package oc.p.chapters._10_.connectingToADatabase.gettingADatabaseConnection;

import utils.resources.db.Dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Conn2 {
    static final String url = Dbs.ZOO.url();

    static void m() {
        try (Connection conn = DriverManager.getConnection(url)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        try (Connection conn = DriverManager.getConnection(url, "user", "password")) {

        } catch (SQLException e) {

        }
    }

    static void m3() throws ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        try (Connection conn = DriverManager.getConnection(url)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        m();
//        m2();
        m3();
    }
}
