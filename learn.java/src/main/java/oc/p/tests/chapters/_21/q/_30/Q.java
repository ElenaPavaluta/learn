package oc.p.tests.chapters._21.q._30;

import java.sql.*;

class Q {

    static void m(){
        String url = "jdbc:derby:blue";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select count(*) from sky")) {
            System.out.println(rs.getInt(1));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
