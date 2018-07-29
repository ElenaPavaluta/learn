package oc.p.chapters._10_.closingDatabaseResources;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import java.sql.*;

/**
 * While it is a good habit to close all three resources,
 * it isn’t strictly necessary. Closing a
 *
 * JDBC resource should close any resources that it created.
 * In particular, the following are true:
 *
 * Closing a Connection also closes the Statement and ResultSet.
 * Closing a Statement also closes the ResultSet.
 */
class Close {

    static String url = Dbs.ZOO.url();

    static void oldWay() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    private static void close(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void newWay(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT)) {
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        oldWay();
        Print.Delimitators.newLine();
        newWay();
    }
}
