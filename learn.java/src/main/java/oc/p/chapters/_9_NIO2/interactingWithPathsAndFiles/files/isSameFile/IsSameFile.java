package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.isSameFile;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
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
class IsSameFile {

    static Path p, symbolicP;
    static final String resourcesPath;

    static final String TXT = "a.txt";
    static final String SYMBOLIC = "symbolicP";

    static {
        Package pkg = new IsSameFile().getClass().getPackage();

        p = Resources.NIO.Path.file(pkg, TXT);
        resourcesPath= Resources.srcMainResourcesPath(pkg);
        symbolicP  = Paths.get(resourcesPath, SYMBOLIC);
        try {
            Files.createSymbolicLink(symbolicP, p);
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(p);
        System.out.println(symbolicP);
        Delimitators.equal();
    }

    static void m() throws IOException {
        Path p = Paths.get(resourcesPath, TXT);
        Path p2 = Paths.get(resourcesPath,SYMBOLIC);

        System.out.println(p);
        System.out.println(p2);

        System.out.println(Files.exists(p));
        System.out.println(Files.exists(p2));
//        System.out.println(Files.isSameFile(test, p2));  //true
    }

    public static void main(String[] args) throws IOException {
       new IsSameFile();
        m();


        Resources.NIO.Path.recursiveDelete(symbolicP, p);
    }
}
