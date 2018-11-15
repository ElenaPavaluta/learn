package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.relativize;

import utils.delimitators.Delimitators;
import utils.print.Print;

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

        System.out.println(p);
        System.out.println(p2);
        Print.Delimitators.newLine();

        System.out.println(p.toAbsolutePath());
        System.out.println(p2.toAbsolutePath());
        Print.Delimitators.newLine();

        System.out.println(p.relativize(p2));
        System.out.println(p2.relativize(p));
        Print.Delimitators.newLine();
    }

    static void m2() {
        Path p = Paths.get("E:\\habitat");
        Path p2 = Paths.get("E:\\sanctuary\\raven");

        System.out.println(p.relativize(p2));  // ..\sanctuary\raven
        System.out.println(p2.relativize(p));  //..\..\habitat
    }

    static void m3() {
        Path p = Paths.get("E:", "a", "b");
        System.out.println(p + " | " + p.isAbsolute());

        Path p2 = Paths.get("b", "c");
        System.out.println(p2 + " | " + p2.isAbsolute());

        /**
         * RE: IllegalArgumentException
         * Can't mix absolute file with relative file
         */
        System.out.println(p.relativize(p2));
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
