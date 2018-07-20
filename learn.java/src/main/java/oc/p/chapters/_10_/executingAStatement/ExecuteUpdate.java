package oc.p.chapters._10_.executingAStatement;

import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

import static utils.resources.db.instance.embedded.derby.ZooDb.Species.*;

/**
 * int executeUpdate(String sql) throws SQLException
 */
class ExecuteUpdate {

    static String url = Dbs.ZOO.url();

    static void m() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT);
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();) {
            String s = INSERT;
            System.out.println(stmt.executeUpdate(s));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m3() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            String s = UPDATE;
            System.out.println(stmt.executeUpdate(s));

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m4() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            String s = DELETE;
            System.out.println(stmt.executeUpdate(s));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m5(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            System.out.println(stmt.executeUpdate(SELECT));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m2();
        m();
        Print.Delimitators.equal();
        m3();
        m();
        Print.Delimitators.equal();
        m4();
        m();
        Print.Delimitators.equal();
        m5();

        Dbs.ZOO.rollback();
    }
}
