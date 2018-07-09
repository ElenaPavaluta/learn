package oc.p.chapters._10_.introducingTheInterfacesOfJdbc;

import utils.print.Print;
import utils.resources.db.Dbs;
import com.sun.org.apache.xpath.internal.SourceTree;
import java.sql.*;
import java.util.List;

class Intro {

    static void m(){
        System.out.println(Dbs.COFFEE.url());
        List<String> tables = Dbs.COFFEE.tables();

        try(Connection conn = DriverManager.getConnection(Dbs.COFFEE.url());
        Statement stmt = conn.createStatement()){
            tables.forEach(n->{
                System.out.println("\n" + n);
                try {
                    Print.print(stmt.executeQuery("SELECT * FROM " + n));
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
    }
}
