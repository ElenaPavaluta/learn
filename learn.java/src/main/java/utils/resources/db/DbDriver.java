package utils.resources.db;

public enum DbDriver {

    DERBY("jdbc:derby");

    private String driver;

    DbDriver(String driver) {
        this.driver = driver;
    }

    public String dbType() {
        return driver.split(":")[1];
    }

    public String driver() {
        return driver;
    }
}
