package oc.p.tests.chapters._21.q._25;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

/**
 * Attention
 *
 * The variables declared in a try with resources are final
 */
class Q {

    static void m() {
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            rs.afterLast();  //0
            /**
             * This method is allowed only on scrollable result set
             */
            System.out.println(rs.getRow());
            rs.previous();
            rs.updateInt(3, 77);
            rs.updateRow();
            rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }

}
