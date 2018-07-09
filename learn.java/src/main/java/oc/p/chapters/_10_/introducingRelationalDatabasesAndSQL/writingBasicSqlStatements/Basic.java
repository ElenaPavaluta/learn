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
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void select() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement()) {
            System.out.println("select");
            ResultSet rs = stmt.executeQuery("SELECT * FROM species");
            while(rs.next()) {
                printSpeciesRow(rs);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printSpeciesRow(ResultSet rs) throws SQLException {
        System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
    }

    static void update() {
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement();) {
            System.out.println("update");
            //1: nb of rows affected
            System.out.println(stmt.executeUpdate("UPDATE SPECIES SET NAME = 'Black zebra' WHERE NAME = 'Zebra'"));

            ResultSet rs = stmt.executeQuery("SELECT * FROM species where NAME = 'Black zebra'");
            while(rs.next()){
                printSpeciesRow(rs);
            }
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
            while(rs.next()){
                printSpeciesRow(rs);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void lastM(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement()){
            System.out.println("lasM");
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*), SUM(num_acres) FROM SPECIES");
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void print(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
        Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * from SPECIES");
//            System.out.println(rs.getMetaData().getColumnCount());
//            System.out.println(rs.getMetaData().getColumnName(1));
//            System.out.println(rs.getMetaData().getColumnName(2));
//            System.out.println(rs.getMetaData().getColumnName(3));
            Print.print(rs);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(Dbs.ZOO.url());
//        insert();
//        select();
//        update();
//        delete();
//        lastM();
        print();
        Dbs.ZOO.rollback();
    }
}
