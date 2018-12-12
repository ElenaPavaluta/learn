package oc.p.tests.chapters._21.q._33;

import utils.resources.db.Dbs;

import java.sql.*;

class EmptyTable {

    static void m() throws SQLException {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select  * from zoo")){
            if(rs.next()){
                System.out.println(rs.getString(1));
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        m();
    }
}
