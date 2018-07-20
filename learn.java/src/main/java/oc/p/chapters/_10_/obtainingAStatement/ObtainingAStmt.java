package oc.p.chapters._10_.obtainingAStatement;

import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

class ObtainingAStmt {

    static void m() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement()) {
            System.out.println(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                                                  ResultSet.CONCUR_READ_ONLY)) {
            System.out.println(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
        Print.Delimitators.equal();
        m2();
    }
}
