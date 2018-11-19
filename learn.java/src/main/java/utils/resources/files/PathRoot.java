package utils.resources.files;

import java.nio.file.Paths;

import static utils.resources.files.Resources.ROOT;
import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;

public enum PathRoot {
    C(Paths.get("/")),
    LEAN_JAVA(Paths.get(ROOT)),
    LEAN_JAVA_SRC_MAIN_RESOURCES(Paths.get(SRC_MAIN_RESOURCES));

    private java.nio.file.Path path;

    PathRoot(final java.nio.file.Path path) {
        this.path = path;
    }

    public java.nio.file.Path path() {
        return path;
    }
}
