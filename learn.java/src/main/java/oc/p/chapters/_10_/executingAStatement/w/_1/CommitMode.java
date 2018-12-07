package oc.p.chapters._10_.executingAStatement.w._1;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

/**
 * A statement always starts in an auto commit mode = true
 */
class CommitMode {

    static void m(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(ZooDb.Animal.SELECT)){
            System.out.println(conn.getAutoCommit());  //true

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
