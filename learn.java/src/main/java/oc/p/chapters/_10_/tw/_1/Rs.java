package oc.p.chapters._10_.tw._1;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;

import java.sql.*;

class Rs {

    static String url = Dbs.ZOO.url();

    static ResultSet resultSet() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            final ResultSet resultSet = stmt.executeQuery(ZooDb.Species.SELECT);
            System.out.println(resultSet.isClosed());  //false
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
        return null;
    }

    static void m() throws SQLException {
        ResultSet rs = resultSet();
        System.out.println(rs == null);  //false
        System.out.println(rs.isClosed());  //true
    }

    public static void main(String[] args) throws SQLException {
        m();
    }
}
