package oc.p.tests.chapters._21.q._26;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

/**
 * If the method updateRow isn't called the updated info
 * aren't written in db
 */
class Q {

    static void m(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            rs.afterLast();
            while (rs.previous()){
                rs.updateInt(3, 9);
//                rs.updateRow();
            }
            rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
