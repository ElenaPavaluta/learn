package oc.p.chapters._10_.introducingRelationalDatabasesAndSQL.writingBasicSqlStatements;

import utils.print.Print;
import utils.resources.db.Dbs;
import java.sql.*;

/**
 * INSERT: Add a new row to the table
 * SELECT: Retrieve data from the table
 * UPDATE: Change zero or more rows in the table
 * DELETE: Remove zero or more rows from the table
 *
 * SQL keywords are case insensitive
 */
class Basic {

    static void insert() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement()) {
            System.out.println("insert");
            String s = "INSERT INTO species VALUES(3, 'Asian Elephant', (7.5))";
            stmt.executeUpdate(s);
            ResultSet rs = stmt.executeQuery("SELECT  * from species");
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void select() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement()) {
            System.out.println("select");
            ResultSet rs = stmt.executeQuery("SELECT * FROM species");
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void update() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement();) {
            System.out.println("update");
            //1: nb of rows affected
            System.out.println(stmt.executeUpdate("UPDATE SPECIES SET NAME = 'Black zebra' WHERE NAME = 'Zebra'"));

            ResultSet rs = stmt.executeQuery("SELECT * FROM species where NAME = 'Black zebra'");
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void delete(){
        try (Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement()){
            System.out.println("delete");
            //1
            System.out.println(stmt.executeUpdate("DELETE from species where name = 'Black zebra'"));
            ResultSet rs = stmt.executeQuery("SELECT * from species");
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void lastM(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement()){
            System.out.println("lasM");
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*), SUM(num_acres) FROM SPECIES");
            Print.print(rs);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(Dbs.ZOO.url());
        insert();
        select();
        update();
        delete();
        lastM();
        Dbs.ZOO.rollback();
    }
}
