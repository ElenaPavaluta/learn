package oc.p.chapters._9_NIO2.util;

import utils.resources.files.Resources;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPath {

    public static Path Absolute_Linux_Path = Paths.get("/land/hippo/harry.happy");
    public static Path Relative_Linux_Path = Paths.get("land/hippo/harry.happy");
    /**
     * When used like this \land\hippo\harry.happy
     * is treated as linuz absolute file
     */
    public static Path Relative_Windows_Path = Paths.get("land\\hippo\\harry.happy");
    public static Path Absolute_Windows_Path = Paths.get(Resources.absolutePath(new TestPath().getClass().getPackage
            ()));
    public static Path Empty_Path = Paths.get("");
}
