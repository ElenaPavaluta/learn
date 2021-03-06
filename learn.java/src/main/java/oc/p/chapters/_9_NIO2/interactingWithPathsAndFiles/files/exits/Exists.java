package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.exits;

import utils.resources.files.util.PathUtil;
import utils.resources.files.Resources;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * static boolean	exists(Path file, LinkOption... options)
 */
class Exists {

    static void m() {
        java.nio.file.Path p = Paths.get("/a/b/c");
        System.out.println(p);
        System.out.println(Files.exists(p));  //false

        java.nio.file.Path p2 = PathUtil.directory(new Exists().getClass().getPackage());
        System.out.println(p2);
        System.out.println(Files.exists(p2));  //true

    }

    public static void main(String[] args) {
        m();
        Resources.clean();
    }
}
