package oc.p.tests.chapters._21.q._35;

import utils.print.Print;
import utils.resources.db.Dbs;

import java.sql.*;

class Q {

    static void m() {
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
        ) {
            stmt.executeUpdate("insert into SPECIES values (3, '3', 3)");
            stmt.executeUpdate("insert into SPECIES values (4, '4', 4)");
            ResultSet rs = stmt.executeQuery("select * from Species order by id asc");
            rs.absolute(-1);
            System.out.println(rs.getInt(1));  //4
            rs.absolute(1);
            System.out.println(rs.getInt(1));  //1

            Print.Delimitators.equal();

            rs.beforeFirst();
            rs.next();
            rs.next();
            System.out.println(rs.getInt(1));  //2

            rs.absolute(1);
            System.out.println(rs.getInt(1));  //1


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) {
        m();

        Dbs.ZOO.rollback();
    }
}
