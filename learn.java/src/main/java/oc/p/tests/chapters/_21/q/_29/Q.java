package oc.p.tests.chapters._21.q._29;

import utils.print.Print;
import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;
import java.util.stream.IntStream;

class Q {

    static void m(){
        try(Connection conn = DriverManager.getConnection(Dbs.ZOO.url());
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            IntStream.rangeClosed(3, 10)
                    .mapToObj(i->"insert into SPECIES values (" + i + ", 'A', " + i + ")")
                    .forEach(s-> {
                        try {
                            stmt.executeUpdate(s);
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    });
            ResultSet rs = stmt.executeQuery(ZooDb.Species.SELECT);
            Print.print(rs);

            rs.beforeFirst();
            rs.absolute(0);
            System.out.println(rs.getRow());  //0

            rs.relative(5);
            System.out.println(rs.getRow());  //5

            rs.relative(-10);
            System.out.println(rs.getRow());  //0

            rs.relative(5);
            System.out.println(rs.getRow());  //5


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
        Dbs.ZOO.rollback();
    }
}
