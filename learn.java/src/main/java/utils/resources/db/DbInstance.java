package utils.resources.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DbInstance {
    protected DbDefinition dbDefinition;

    protected DbInstance(DbDefinition dbDefinition) {
        this.dbDefinition = dbDefinition;
        if(!exists()) {
            createAndPopulate();
        }
    }

    public DbDefinition getDbDefinition() {
        return dbDefinition;
    }

    protected abstract void createAndPopulateTables(Statement stmt) throws SQLException;

    protected final void rollback() {
        try(Connection connection = DriverManager.getConnection(dbDefinition.url());
            Statement stmt = connection.createStatement()) {
            List<String> lst = tables(stmt);
            dropTables(stmt, lst);
            createAndPopulateTables(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean exists() {
        try(Connection conn = DriverManager.getConnection(dbDefinition.url())) {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, null, null);
            return rs.next();
        } catch(SQLException e) {
            return false;
        }
    }

    private void createAndPopulate() {
        try(Connection conn = DriverManager.getConnection(dbDefinition.createUrl());
            Statement stmt = conn.createStatement()) {
            createAndPopulateTables(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTables(Statement stmt, List<String> lst) {
        lst.forEach(
                s -> {
                    try {
                        stmt.executeUpdate("DROP TABLE " + s);
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                });
    }


    protected List<String> tables(){
        try(Connection conn = DriverManager.getConnection(dbDefinition.url());
        Statement stmt = conn.createStatement()) {
            return tables(stmt);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> tables(Statement stmt) {
        List<String> lst = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT TABLENAME FROM SYS.SYSTABLES WHERE TABLETYPE='T'");
            while(rs.next()) {
                lst.add(rs.getString(1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }
}
