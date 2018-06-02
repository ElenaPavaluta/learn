package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.readingCommonAttributes;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class RCA {

    static String loc = Resources.srcMainResourcesPath(new RCA());
    static Path dir = Paths.get(loc);
    static Path file = Paths.get(loc, "rca");
    static String A_B_C = "a\\b\\c";
    static Path dirLink = Paths.get(loc, A_B_C);
    static Path link;

    static {
        try {
            dir = Files.createDirectories(dir);
            file = Files.createFile(file);

            dirLink = Files.createDirectories(dirLink);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void test(Path p){
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
        if(link !=null) Files.deleteIfExists(link);
        link = Paths.get(loc, A_B_C, "link");
        link = Files.createLink(link, dir);  //CE
        test(link);
    }
    static void m4() throws IOException {
        if(link !=null) Files.deleteIfExists(link);
        link = Paths.get(loc, A_B_C, "link");
        link = Files.createLink(link, file);
        test(link);
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
//        m3();
        m4();
//        Resources.recursiveDelete(dir, file, dirLink, link);
    }
}
