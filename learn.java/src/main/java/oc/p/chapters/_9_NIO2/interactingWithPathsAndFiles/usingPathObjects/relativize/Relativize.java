package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.relativize;

import utils.delimitators.Delimitators;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	relativize(Path other)
 *
 * Constructs a relative path between this path and a given path.
 */
class Relativize {

    static void m() {
        Path p = Paths.get("fish.txt");  // ..\birds.txt
        Path p2 = Paths.get("birds.txt");  // ..\fish.txt

        System.out.println(p.relativize(p2));
        System.out.println(p2.relativize(p));
    }

    static void m2() {
        Path p = Paths.get("E:\\habitat");  //  ..\sanctuary\raven
        Path p2 = Paths.get("E:\\sanctuary\\raven");  // ..\..\habitat

        System.out.println(p.relativize(p2));
        System.out.println(p2.relativize(p));
    }

    static void m3() {
        Path p = Paths.get("E:", "a", "b");
        System.out.println(p + " | " + p.isAbsolute());

        Path p2 = Paths.get("b", "c");
        System.out.println(p2 + " | " + p2.isAbsolute());

        /**
         * RE: IllegalArgumentException
         * Can't mix absolute path with relative path
         */
        System.out.println(p.relativize(p2));
    }

    public static void main(String[] args) {
        m();
        Delimitators.newLine();

        m2();
        Delimitators.newLine();

        m3();
    }
}
