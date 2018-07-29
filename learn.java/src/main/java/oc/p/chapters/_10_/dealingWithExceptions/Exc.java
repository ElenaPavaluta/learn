package oc.p.chapters._10_.dealingWithExceptions;

import utils.resources.db.Dbs;
import java.sql.*;

class Exc {

    static String url = Dbs.ZOO.url();

    static void m(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT not_a_column from Animal"))
        {
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    public static void main(String[] args) {
        m();
    }
}
