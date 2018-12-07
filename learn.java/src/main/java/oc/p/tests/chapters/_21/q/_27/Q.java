package oc.p.tests.chapters._21.q._27;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

/**
 * Makes all changes made since the previous commit/rollback permanent and releases any database locks
 * currently held by this <code>Connection</code> object.
 * Should be used only when auto-commit mode has been disabled.
 * void commit() throws SQLException
 *
 *
 * Undoes all changes made in the current transaction and releases any database locks currently held
 * by this <code>Connection</code> object.
 * Should be used only when auto-commit mode has been disabled.
 * void rollback() throws SQLException
 */
class Q {

    static void m(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){

            conn.setAutoCommit(false);
            stmt.executeUpdate("insert into SPECIES values (3, 'A', 3)");
            stmt.executeUpdate("insert into SPECIES values (4, 'B', 4)");

//            conn.commit();
            conn.rollback();

            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
            conn.setAutoCommit(true);
            stmt.executeUpdate("insert into SPECIES values (5, 'C', 5)");

            rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);

        }catch (SQLException e){
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
