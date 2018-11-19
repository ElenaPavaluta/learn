package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.isSameFile.tw;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean	isSameFile(Path file, Path path2)
 *
 * Tests if two paths locate the same file.
 *
 * This isSameFile() method does not compare the contents of the file. For
 * example, two files may have identical content and attributes, but if they
 * are in different locations, then this method will return false .
 */
class SameFile {


    static void m() throws IOException {
        File file = Resources.File.file(new SameFile().getClass().getPackage(), "s.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        Delimitators.equal();

        Path p = Paths.get(file.getPath());
        Path p2 = Paths.get(file.getAbsolutePath());

        System.out.println(Files.isSameFile(p, p2));

        Resources.cleanSrcMainResources();
    }

    static void m2() throws IOException {
        Path p = Paths.get("a/b/c");
        Path p2 = Paths.get(p.toAbsolutePath().toString());
        System.out.println(p);
        System.out.println(p2);
        Delimitators.equal();

        System.out.println(Files.exists(p));
        System.out.println(Files.exists(p2));
        /**
         * Throws a checked exception since the files don't actually exists
         */
        System.out.println(Files.isSameFile(p, p2));
    }

    public static void main(String[] args) throws IOException {
//        createAndPopulate();
        m2();
    }
}
