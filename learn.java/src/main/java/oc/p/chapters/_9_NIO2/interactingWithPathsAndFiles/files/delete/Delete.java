package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.delete;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static void	delete(Path path)
 * Deletes a file.
 *
 * static boolean	deleteIfExists(Path path)
 * Deletes a file if it exists.
 */
class Delete {

    static String loc = Resources.srcMainResourcesPath(new Delete());
    static Path p = Paths.get(loc);
    static Path pa = Paths.get(loc, "a");
    static Path pa1 = Paths.get(loc, "a", "1");
    static Path pa2 = Paths.get(loc, "a", "2");
    static Path pa3 = Paths.get(loc, "a", "3");
    static Path[] toDel = new Path[]{p, pa, pa1, pa2, pa3,};

    static void init() {
        try {
            pa1 = Files.createDirectories(pa1);
            pa2 = Files.createDirectories(pa2);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    static void m() {
        init();
        try {
            Files.delete(pa2);
            System.out.println("pa2 deleted");
        } catch(IOException e) {
            System.out.println("pa2:" +  e.getMessage());
        }

        try {
            Files.delete(pa3);
        } catch(IOException e) {
            System.out.println("pa3 hasn' t been created, so it does not exists");
        }

        try {
            Files.delete(pa);
        } catch(IOException e) {
            System.out.println("pa is non empty directory, so can't be deleted");
        }
    }

    static void m2(){
        init();
        try {
            System.out.println(Files.deleteIfExists(pa2));  //true
            System.out.println("pa2 deleted");
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Files.deleteIfExists(pa3));  //false
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Files.deleteIfExists(pa));
        } catch(IOException e) {
            System.out.println("Can't delete a non empty dir");
        }
    }

    public static void main(String[] args) {
//        createAndPopulate();
        m2();
        Resources.NIO.File.Path.recursiveDelete(toDel);
    }
}
