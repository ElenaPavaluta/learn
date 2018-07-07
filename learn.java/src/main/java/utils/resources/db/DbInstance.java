package utils.resources.db;

import java.sql.*;

public abstract class DbInstance {
    protected DbDefinition dbDefinition;

    protected DbInstance(DbDefinition dbDefinition) {
        this.dbDefinition = dbDefinition;
        if(!exists()) {
            createAndPopulate();
        }
    }

    protected abstract void createAndPopulate();

    public DbDefinition getDbDefinition() {
        return dbDefinition;
    }

    protected boolean exists() {
        try(Connection conn = DriverManager.getConnection(dbDefinition.url())) {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, null, null);
            return rs.next();
        } catch(SQLException e) {
            return false;
        }
    }
}
