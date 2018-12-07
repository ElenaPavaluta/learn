package oc.p.tests.chapters._21.q._24;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {

    static void m(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT)) {
            System.out.println(rs.getRow());  //0;
            rs.next();
            System.out.println(rs.getRow()); //1
            rs.absolute(0);
            System.out.println(rs.getRow());  //0
            System.out.println(rs.getInt(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
