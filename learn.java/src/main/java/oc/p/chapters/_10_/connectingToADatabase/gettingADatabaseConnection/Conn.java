package oc.p.chapters._10_.connectingToADatabase.gettingADatabaseConnection;

import utils.resources.db.Dbs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Conn {

    static void m() {
        System.out.println(Dbs.ZOO.url());
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url())) {
            System.out.println(conn);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url(),
                                                          "cip", "pass")) {
            System.out.println(conn);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
