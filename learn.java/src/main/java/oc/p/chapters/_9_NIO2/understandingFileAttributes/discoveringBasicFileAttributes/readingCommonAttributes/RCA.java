package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.readingCommonAttributes;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * static boolean	isDirectory(Path path, LinkOption... options)
 * Tests whether a file is a directory.
 *
 * static boolean	isRegularFile(Path path, LinkOption... options)
 * Tests whether a file is a regular file with opaque content.
 *
 * static boolean	isSymbolicLink(Path path)
 * Tests whether a file is a symbolic link.
 *
 * These methods throw only RE
 *
 * Seems that I can have symbolic link either to a file or dir,
 * but a link can be only to a file
 */
class RCA {

    static final Package PACKAGE = new RCA().getClass().getPackage();
    static String loc = Resources.srcMainResourcesPath(PACKAGE);
    static java.nio.file.Path dir = Paths.get(loc);
    static java.nio.file.Path file = Paths.get(loc, "rca");
    static String A_B_C = "a\\b\\c";
    static java.nio.file.Path dirLink = Paths.get(loc, A_B_C);
    static java.nio.file.Path link;


    static {
        try {
            dir = Files.createDirectories(dir);
            Files.deleteIfExists(file);
            file = CreatePopulate.NIO.File.Path.file(PACKAGE);
            dirLink = Files.createDirectories(dirLink);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void test(java.nio.file.Path p){
        System.out.println(p.getFileName());
        System.out.println(Files.isDirectory(p));
        System.out.println(Files.isRegularFile(p));
        System.out.println(Files.isSymbolicLink(p));
        Delimitators.equal();
    }

    static void m(){
        test(dir);
        test(file);
    }

    static void m2() throws IOException {
        if(link !=null) Files.deleteIfExists(link);
        link = Paths.get(loc, A_B_C, "link");
        test(link);
    }

    static void m3() throws IOException {
        link = Paths.get(loc, A_B_C, "link");
        Files.deleteIfExists(link);
        link = Files.createLink(link, dir);  //RE
        test(link);
    }
    static void m4() throws IOException {
        link = Paths.get(loc, A_B_C, "link");
        Files.deleteIfExists(link);
        link = Files.createLink(link, file);
        test(link);
    }

    static void m5() throws IOException {
        link = Paths.get(loc, A_B_C, "link");
        Files.deleteIfExists(link);
        link = Files.createSymbolicLink(link, dir);
        test(link);
    }

    static void m6() throws IOException {
        link = Paths.get(loc, A_B_C, "link");
        Files.deleteIfExists(link);
        link = Files.createSymbolicLink(link, file);
        test(link);
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
//        m3();
//        m4();
        m5();
//        m6();
        Resources.clean();
    }
}
