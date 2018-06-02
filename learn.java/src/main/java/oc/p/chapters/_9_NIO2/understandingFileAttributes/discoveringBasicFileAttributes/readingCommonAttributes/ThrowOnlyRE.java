package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.readingCommonAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * These methods throw only RE
 */
class ThrowOnlyRE {

    static Path path = Paths.get("a", "b", "c");

    static void m(){
        if(Files.exists(path) && Files.isDirectory(path)){
            System.out.println("exists and is directory");
        }else{
            System.out.println("not a dir");
        }
    }

    static void m2(){
        if(Files.isDirectory(path)){
            System.out.println("is directory");
        }else{
            System.out.println("not a dir");
        }
    }

    public static void main(String[] args) {
        m();
        m2();
    }
}
