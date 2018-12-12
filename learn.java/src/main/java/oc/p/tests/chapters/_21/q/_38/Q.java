package oc.p.tests.chapters._21.q._38;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {

    static void m() {
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            conn.setAutoCommit(false);
            stmt.executeUpdate("insert into SPECIES values (3, '3', 3)");
            stmt.executeUpdate("insert into SPECIES values (4, '4', 4)");
            conn.rollback();
            conn.setAutoCommit(true);
            stmt.executeUpdate("insert into SPECIES values (5, '5', 5)");
            conn.rollback();

            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
        Dbs.ZOO.rollback();
    }
}

