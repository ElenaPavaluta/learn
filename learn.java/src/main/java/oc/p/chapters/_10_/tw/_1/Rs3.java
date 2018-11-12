package oc.p.chapters._10_.tw._1;

import utils.resources.db.Dbs;

import java.sql.*;

class Rs3 {
    static String url = Dbs.ZOO.url();

    static void m(){
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()){

        }catch (SQLException e){
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }
}
