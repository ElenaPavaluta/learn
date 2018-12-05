package oc.p.tests.chapters._21.q._18;

import utils.print.Print;
import utils.resources.db.Dbs;

import java.sql.*;

class Q {

    static final String URL = Dbs.ZOO.url();

    static void m() {
        try (Connection conn = DriverManager.getConnection(URL);
//             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);   // beforeFirst has effect
             Statement stmt = conn.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.TYPE_SCROLL_SENSITIVE);  //beforeFirst has no effect
        ) {
            ResultSet rs = stmt.executeQuery("select * from SPECIES where  name = 'Zebra'");

            Print.print(rs);
            rs.beforeFirst();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
            }

            rs.beforeFirst();
            Print.print(rs);

            rs.beforeFirst();
            System.out.println(rs.getRow());  //0 on both cases

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    static void m19(){
        try(Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);){
            ResultSet rs = stmt.executeQuery("select name from SPECIES where NUM_ACRES > 0");
            Print.print(rs);

            rs.beforeFirst();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }

            Print.Delimitators.equal();
            rs.beforeFirst();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

//            Print.Delimitators.equal();
//            rs.beforeFirst();
//            System.out.println(rs.getString(1));
//
//            Print.Delimitators.equal();
//            rs.beforeFirst();
//            System.out.println(rs.getString("name"));
        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) {
//        m();
        m19();
    }
}
