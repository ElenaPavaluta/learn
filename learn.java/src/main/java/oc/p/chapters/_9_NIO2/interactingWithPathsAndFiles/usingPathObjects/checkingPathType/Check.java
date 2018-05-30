package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.checkingPathType;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static oc.p.chapters._9_NIO2.util.TestPath.*;

/**
 * boolean	isAbsolute()
 *
 * Path	toAbsolutePath()
 */
class Check {
    static List<Path> paths = Arrays.asList(Absolute_Linux_Path,
                                            Relative_Linux_Path,
                                            Absolute_Windows_Path,
                                            Relative_Windows_Path,
                                            Empty_Path);

    static void m() {
        paths.forEach(p -> System.out.println(p + ": " + p.isAbsolute() + " \n" + p.toAbsolutePath() + "\n"));
    }

    public static void main(String[] args) {
        m();
    }
}
