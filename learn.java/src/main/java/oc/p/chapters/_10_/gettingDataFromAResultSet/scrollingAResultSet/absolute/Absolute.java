package oc.p.chapters._10_.gettingDataFromAResultSet.scrollingAResultSet.absolute;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import java.sql.*;

/**
 * boolean absolute( int row ) throws SQLException;
 */
class Absolute {

    static String url = Dbs.ZOO.url();

    static void m(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);  //has 2 rows
            Print.print(rs);
            Print.Delimitators.equal();

            //moves the cursor before the first row
            System.out.println(rs.absolute(0));  //false, because doesn't points to a valid row

            System.out.println(rs.absolute(1));  //true
            System.out.println(rs.absolute(2));   //true
            System.out.println(rs.absolute(33));  //false

            Print.Delimitators.equal();

            System.out.println(rs.absolute(0));  //false

            //moves the cursor to the last row
            System.out.println(rs.absolute(-1));  //true
            System.out.println(rs.absolute(-2)); //true
            System.out.println(rs.absolute(-33));  //false

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
