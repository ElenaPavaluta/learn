package utils.resources.db;

import java.io.File;

import static utils.resources.db.DbDefinition.LocationType.EMBEDDED;
import static utils.resources.db.DbDriver.DERBY;
import static utils.resources.files.Resources.SRC_MAIN_RESOURCES_DB;
import static utils.resources.files.Separation.SLASH;

public enum DbDefinition {

    ZOO(DERBY, "zoo", EMBEDDED),
    COFFEE(DERBY, "coffee", EMBEDDED);

    private DbDriver driver;
    private String name;
    private LocationType type;

    DbDefinition(DbDriver driver, String name, LocationType type) {
        this.driver = driver;
        this.name = name;
        this.type = type;
    }

    public String url() {
        return driver.driver() + ":" + path();
    }

    public String forName() {
        return driver.forName();
    }

    public String path() {
        return SLASH.separationOf(SRC_MAIN_RESOURCES_DB) + File.separator + type.name().toLowerCase() +
                File.separator + driver.dbType() + File.separator + name;
    }

    public String createUrl() {
        return url() + ";create=true";
    }

    public DbDriver getDriver() {
        return driver;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    enum LocationType {
        EMBEDDED,
        REMOTE;
    }
}

