package oc.p.tests.chapters._21.q._20;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Q {

    static String url = Dbs.ZOO.url();
    static void m(){


        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt =conn.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE)){
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    static void m2(){
        try (Connection conn = DriverManager.getConnection(url);
//        Statement stmt = conn.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE  //ok
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
        )){
            ResultSet rs = stmt.executeQuery(ZooDb.Animal.SELECT);
            Print.print(rs);
            rs.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
