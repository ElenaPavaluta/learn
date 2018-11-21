package utils.resources.files;

import static utils.resources.files.Resources.path;

public enum Location {

    SRC_MAIN_JAVA("src.main.java"),
    SRC_MAIN_RESOURCES("src.main.resources"),
    SRC_MAIN_RESOURCES_DB("src.main.resources.db");

    private String location;

    Location(final String location) {
        this.location = location;
    }

    public String get() {
        return location;
    }

    public String toPath(){
        return path(location);
    }
}
