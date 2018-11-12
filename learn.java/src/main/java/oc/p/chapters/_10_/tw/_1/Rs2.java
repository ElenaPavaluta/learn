package oc.p.chapters._10_.tw._1;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Rs2 {

    static String url = Dbs.ZOO.url();

    static void m() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT)) {

            rs.beforeFirst();
            System.out.println(rs.isBeforeFirst());  //true
            System.out.println(rs.getRow());  //0

            rs.afterLast();
            System.out.println(rs.isAfterLast());  //true
            System.out.println(rs.getRow());

            rs.absolute(0);
            System.out.println(rs.isBeforeFirst());  //true
            System.out.println(rs.getRow());  //0

            System.out.println(rs.first());  //true
            System.out.println(rs.getRow());  //1

            System.out.println(rs.last());  //true
            System.out.println(rs.getRow());  //last

            System.out.println(rs.relative(-1));  //true
            System.out.println(rs.getRow());  //1


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
