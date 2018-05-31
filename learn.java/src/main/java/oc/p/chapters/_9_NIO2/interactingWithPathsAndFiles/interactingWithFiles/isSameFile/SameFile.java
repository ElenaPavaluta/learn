package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.interactingWithFiles.isSameFile;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean	isSameFile(Path path, Path path2)
 *
 * Tests if two paths locate the same file.
 */
class SameFile {


    static void m() throws IOException {
        File file = Resources.IO.File.file(new SameFile().getClass().getPackage(), "s.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        Delimitators.equal();

        Path p = Paths.get(file.getPath());
        Path p2 = Paths.get(file.getAbsolutePath());

        System.out.println(Files.isSameFile(p, p2));

        Resources.IO.File.recursiveDelete(file);
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
