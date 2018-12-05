package oc.p.tests.chapters._21.q._20;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {

    static void m(){
        String url = Dbs.ZOO.url();

        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt =conn.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE)){
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

//    static void m

    public static void main(String[] args) {
        m();
    }
}
