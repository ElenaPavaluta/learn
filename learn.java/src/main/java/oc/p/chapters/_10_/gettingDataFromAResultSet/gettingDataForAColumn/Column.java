package oc.p.chapters._10_.gettingDataFromAResultSet.gettingDataForAColumn;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Column {
    static String url = Dbs.ZOO.url();

    static void m() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Animal.SELECT);
            Print.print(rs);
            Print.Delimitators.equal();

            rs.beforeFirst();

            while(rs.next()) {
                Date d = rs.getDate("DATE_BORN");
                Time t = rs.getTime("DATE_BORN");
                Timestamp timestamp = rs.getTimestamp("DATE_BORN");
                System.out.println(d + " -> " + t);
                System.out.println(timestamp);

                LocalDate ld = d.toLocalDate();
                LocalTime lt = t.toLocalTime();
                LocalDateTime ldt = timestamp.toLocalDateTime();
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void object() {
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(ZooDb.Animal.SELECT);
            while(rs.next()) {
                Object o = rs.getObject("DATE_BORN");
                System.out.println(o);
                if(o instanceof LocalDate) {  //false
                    System.out.println((LocalDate) o);
                }
                if(o instanceof LocalTime) {  //false
                    System.out.println((LocalTime) o);
                }
                if(o instanceof LocalDateTime) {  //false
                    System.out.println((LocalDateTime) o);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    static void m3(){
        try(Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs =stmt.executeQuery(ZooDb.Animal.SELECT);

            rs.first();

            int id = rs.getInt(1);
            long speciesid = rs.getLong(2);
            double speciesId2 = rs.getDouble(2);
            String name = rs.getString(3);

            System.out.println(id);
            System.out.println(speciesid);
            System.out.println(speciesId2);
            System.out.println(name);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        m();
//        object();
        m3();
    }
}
