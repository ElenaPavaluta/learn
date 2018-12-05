package oc.p.tests.chapters._21.q._12;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {
    static String url = Dbs.ZOO.url();

    static void m() {
        String forName = Dbs.ZOO.forName();

        try {
            Class.forName(forName);  //Needed only for jdbc version < 4.0
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select count (*) from ANIMAL");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    static void m2(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select count (*) from NONE");
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    static void m3(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            System.out.println(stmt.executeUpdate("delete from SPECIES"));

            ResultSet rs = stmt.executeQuery("select count (*) from SPECIES");
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
        Dbs.ZOO.rollback();
    }
}
