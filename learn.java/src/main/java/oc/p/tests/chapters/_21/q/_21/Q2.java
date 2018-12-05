package oc.p.tests.chapters._21.q._21;

import utils.resources.db.Dbs;

import java.sql.*;

class Q2 {

    static void m(Connection conn) {
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = stmt.executeQuery("select * from None");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void callM() {
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url())) {
            System.out.println(conn.isClosed());  //false
            m(conn);
            System.out.println(conn.isClosed());  //false
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        callM();
    }
}
