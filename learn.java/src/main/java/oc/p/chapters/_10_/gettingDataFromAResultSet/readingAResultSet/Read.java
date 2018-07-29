package oc.p.chapters._10_.gettingDataFromAResultSet.readingAResultSet;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import com.sun.javafx.tk.PrintPipeline;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * JDBC starts counting with one rather than zero/
 * Column indexes begin with 1.
 *
 * Always use an if statement or while loop when calling rs.next()
 */
class Read {
    static String url = Dbs.ZOO.url();

    static void m() {
        Map<Integer, String> idToName = new HashMap<>();
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM species");
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                idToName.put(id, name);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        idToName.forEach((k, v) -> System.out.println(k + " -> " + v));
    }


    //prints false when it reaches the end
    static void m2() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM species");
//            Print.print(rs);
            IntStream.range(0, 5).forEach(i -> {
                try {
                    System.out.println(rs.next());
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    //prints false when it reaches the end
    static void m3() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            System.out.println(rs.last()); //true
            IntStream.rangeClosed(0, 10).forEach(i -> {
                try {
                    System.out.println(rs.previous());
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m4() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            System.out.println(rs.first());  //true
            System.out.println(rs.last());  //true
            System.out.println(rs.next());  //false
            System.out.println(rs.getRow());  //0
            Print.print(rs);
            System.out.println(rs.getString(2));  //SQlException
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m5(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);
            Print.Delimitators.equal();
            Print.print(rs);
            Print.Delimitators.equal();
            rs.beforeFirst();
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
    }
}
