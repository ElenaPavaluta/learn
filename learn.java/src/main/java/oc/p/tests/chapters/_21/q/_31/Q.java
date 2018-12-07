package oc.p.tests.chapters._21.q._31;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {

    static void m() {
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            conn.setAutoCommit(false);

            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            ResultSet rs2 = stmt.executeQuery(ZooDb.Species.SELECT);

            Print.print(rs);
            Print.print(rs2);
//            System.out.println(rs.next());
//            System.out.println(rs2.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
