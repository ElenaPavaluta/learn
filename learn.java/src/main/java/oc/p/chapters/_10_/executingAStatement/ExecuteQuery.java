package oc.p.chapters._10_.executingAStatement;
import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

import static utils.resources.db.instance.embedded.derby.ZooDb.Species.*;

/**
 * ResultSet executeQuery(String sql) throws SQLException
 */
class ExecuteQuery {

    static String url = Dbs.ZOO.url();

    static void m(){
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(SELECT);
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2(){
        try (Connection conn  = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()){
            ResultSet rs = null;
//            rs = stmt.executeQuery(UPDATE); //SQLException

//            rs =stmt.executeQuery(INSERT);  //SQLException

            rs = stmt.executeQuery(DELETE);  //SQL
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m3(){

    }

    public static void main(String[] args) {
//        m();
        m2();

        Dbs.ZOO.rollback();
    }
}
