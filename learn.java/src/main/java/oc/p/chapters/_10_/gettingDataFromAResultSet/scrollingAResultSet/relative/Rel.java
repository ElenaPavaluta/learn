package oc.p.chapters._10_.gettingDataFromAResultSet.scrollingAResultSet.relative;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import java.sql.*;

/**
 *
 */
class Rel {
    static String url = Dbs.ZOO.url();

    static void m() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);

            System.out.println(rs.next());  //true

            //doesn't actually moves the cursor
            System.out.println(rs.relative(0));  //true

            System.out.println(rs.relative(1));   //true

            //The cursors is moved after last
            System.out.println(rs.relative(34));  //false

            Print.Delimitators.newLine();

            //the cursor is moved at last
            System.out.println(rs.relative(-1));  //true
            System.out.println(rs.relative(-1));  //true
            System.out.println(rs.relative(-1));  //false

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
