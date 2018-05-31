package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.dir;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path	createDirectory(Path dir, FileAttribute<?>... attrs)
 * Creates a new directory.
 *
 * static Path	createDirectories(Path dir, FileAttribute<?>... attrs)
 * Creates a directory by creating all nonexistent parent directories first.
 */
class Create {
   static String location = Resources.srcMainResourcesPath(new Create().getClass().getPackage());

    static {
        System.out.println(location);
    }

    static void m() throws IOException {
        Path p = Paths.get(location);
        p = Files.createDirectories(p);
        System.out.println(Files.exists(p));  //true
        System.out.println(Files.isDirectory(p));  //true
        System.out.println(Files.isRegularFile(p));  //false
        System.out.println(Files.isSymbolicLink(p));  //false
        Delimitators.equal();

        p = Paths.get(location, "a");
        p = Files.createDirectory(p);

        Resources.NIO2.Path.recursiveDelete(p);
    }

    static void m2() throws IOException {
        Path p = Paths.get(location, "a", "a");
        p = Files.createDirectories(p);
        Resources.NIO2.Path.recursiveDelete(p);
    }

    static void m3() throws IOException {
        Path p = Paths.get(location, "a", "b");

        /**
         * CE
         */
        p = Files.createDirectory(p);
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
        m3();
    }
}


