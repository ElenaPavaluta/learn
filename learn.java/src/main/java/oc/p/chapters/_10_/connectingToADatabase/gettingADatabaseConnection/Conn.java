package oc.p.chapters._10_.connectingToADatabase.gettingADatabaseConnection;

import utils.resources.db.Dbs;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * When Class.forName()
 * is used, the error about an invalid class occurs on that line and throws a
 * ClassNotFoundException
 *
 * Having META-INF/service/java.sql.Driver inside the JAR became mandatory
 * with JDBC 4.0 in Java 6.
 * Before that, some drivers included it and some didn’t.
 */
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
                                                          "cip",
                                                          "pass")) {
            System.out.println(conn);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m3() {
        try {
            /**
             * Throws a ClassCastException
             */
            Class.forName("not.a.driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void m4() {
        try {
            Class.forName("derby");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void m5() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            System.out.println(conn);
            conn.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
//        m5();
    }
}
