package oc.p.chapters._9_NIO2.util;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static utils.resources.files.Separation.SLASH;

public class TestPath {

    public static Path WORKING_DIR = Paths.get("").toAbsolutePath();
    public static Path Absolute_Linux_Path = Paths.get("/land/hippo/harry.happy");
    public static Path Relative_Linux_Path = Paths.get("land/hippo/harry.happy");
    /**
     * When used like this \land\hippo\harry.happy
     * is treated as linux absolute file
     */
    public static Path Relative_Windows_Path = Paths.get("land\\hippo\\harry.happy");
    //    public static Path Absolute_Windows_Path = Paths.get(Resources.absolutePath(new TestPath().getClass().getPackage()));
    public static Path Absolute_Windows_Path = Paths.get("to do");
    public static Path Empty_Path = Paths.get("");

    public static List <Path> pathList = Arrays.asList(WORKING_DIR, Absolute_Linux_Path, Relative_Linux_Path, Absolute_Windows_Path, Relative_Windows_Path, Empty_Path);

    static Path SRC_MAIN_JAVA = Paths.get(SLASH.separationOf(Resources.SRC_MAIN_JAVA));
    static Instant thisYear = Instant.now().minus(LocalDateTime.now().getDayOfYear() - 1, ChronoUnit.DAYS);
    static Instant thisMonth = Instant.now().minus(LocalDateTime.now().getDayOfMonth() - 1, ChronoUnit.DAYS);

    public static Stream <Path> pathsThisYear() {
        return getPathStream(thisYear);
    }

    public static Stream <Path> pathsThisMonth() {
        return getPathStream(thisMonth);
    }

    public static Stream <Path> allPaths() {
        try {
            return Files.walk(Paths.get(SLASH.separationOf(Resources.SRC_MAIN_JAVA)));
        } catch (IOException e) {
            return null;
        }
    }

    private static Stream <Path> getPathStream(Instant thisYear) {
        try {
            return Files.find(SRC_MAIN_JAVA, Byte.MAX_VALUE, (p, bfa) -> bfa.creationTime().toInstant().isAfter(thisYear));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
