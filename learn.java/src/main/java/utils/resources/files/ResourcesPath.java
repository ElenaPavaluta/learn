package utils.resources.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum ResourcesPath {

    SRC_MAIN_JAVA(Paths.get(Location.SRC_MAIN_JAVA.toPath())),
    SRC_MAIN_RESOURCES(Paths.get(Location.SRC_MAIN_RESOURCES.toPath()));

    private Path path;

    ResourcesPath(final Path path) {
        this.path = path;
    }

    public Path get() {
        return path;
    }
}
