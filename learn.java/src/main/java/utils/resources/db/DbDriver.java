package utils.resources.db;

public enum DbDriver {

    DERBY("jdbc:derby", "org.apache.derby.jdbc.ClientDriver");

    private String driver;
    private String forName;

    DbDriver(final String driver, final String forName) {
        this.driver = driver;
        this.forName = forName;
    }

    public String dbType() {
        return driver.split(":")[1];
    }

    public String driver() {
        return driver;
    }

    public String forName() {
        return forName;
    }
}
