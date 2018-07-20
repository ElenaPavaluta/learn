package oc.p.chapters._10_.obtainingAStatement.choosingAResultSet.type;

import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

/**
 * By default, a ResultSet is in TYPE_FORWARD_ONLY mode
 *
 * ResultSet.TYPE_SCROLL_INSENSITIVE:
 *  - allow you to go through the data in any order
 *  - static view of what the ResultSet looked like when you did the query
 *
 * ResultSet.TYPE_SCROLL_SENSITIVE
 * - allow you to go through the data in any order
 * - see the latest data when scrolling through the ResultSet
 * - most databases and database drivers don’t actually support,
 * so the driver can “helpfully” downgrade to one that is
 *
 */
class ResultSetType {

    static String s = "SELECT * from species";

    static void m(){
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                                   ResultSet.CONCUR_READ_ONLY)) {
            Print.print(stmt.executeQuery(s));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                              ResultSet.CONCUR_READ_ONLY)) {
            moveInBothDirs(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void moveInBothDirs(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery(s);

        // True if the cursor is on a valid row; Moves the cursor
        System.out.println(rs.last());
        Print.print(rs);

        //True if the cursor is on a valid row; Moves the cursor
        System.out.println(rs.first());
        Print.print(rs);

        //Moves the cursor before the first row
        rs.beforeFirst();
        Print.print(rs);
    }

    static void m3(){
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                              ResultSet.CONCUR_READ_ONLY)){
            moveInBothDirs(stmt);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
