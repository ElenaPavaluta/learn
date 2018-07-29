package oc.p.chapters._10_.gettingDataFromAResultSet.scrollingAResultSet.firstAndLast;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import java.sql.*;

class Rs {

    static String url = Dbs.ZOO.url();

    static void m(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);

            rs.afterLast();  //
            Print.print(rs);

            rs.beforeFirst();
            Print.print(rs);

            Print.Delimitators.equal();

            System.out.println(rs.first());  //true
            System.out.println(rs.last());  //true

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m2(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery("select id from species where id  =-99");
            System.out.println(rs.first()); //false
            System.out.println(rs.last());  //false
        } catch(SQLException e) {
            e.printStackTrace();
        } ;
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
