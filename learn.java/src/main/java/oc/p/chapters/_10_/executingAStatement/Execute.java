package oc.p.chapters._10_.executingAStatement;

import utils.resources.db.Dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static utils.resources.db.instance.embedded.derby.ZooDb.Species.*;
/**
 * boolean execute(String sql) throws SQLException
 *
 * true if the first result is a ResultSet
 */
class Execute {

    static String url = Dbs.ZOO.url();

    static void m(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()){

            System.out.println(stmt.execute(SELECT));  //true
            System.out.println(stmt.execute(INSERT));  //false
            System.out.println(stmt.execute(UPDATE));  //false
            System.out.println(stmt.execute(DELETE));  //false
            System.out.println(stmt.execute(DELETE));  //false


        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
