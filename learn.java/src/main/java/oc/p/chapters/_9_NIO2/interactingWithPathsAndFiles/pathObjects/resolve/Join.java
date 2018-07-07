package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.resolve;

import java.nio.file.Path;
import java.nio.file.Paths;
import static oc.p.chapters._9_NIO2.util.TestPath.*;

/**
 * Path	resolve(Path other)
 * Resolve the given file against this file.
 *
 * Path	resolve(String other)
 * Converts a given file string to a Path and resolves it against this Path
 * in exactly the manner specified by the resolve method.
 *
 *
 * If the other parameter is an absolute file then
 * this method returns other.
 * If other is an empty file then this method returns this file.
 * Otherwise this method considers this file to be a file
 * and resolves the given file against this file.
 * In the simplest case, the given file does not have a root component,
 * in which case this method joins the given file to this file and
 * returns a resulting file that ends with the given file.
 * Where the given file has a root component then resolution
 * is highly implementation dependent and therefore unspecified.
 */
class Join {

    static void m() {
        Path p = Paths.get("/cats/../panther");  // \cats\..\panther\food
        Path p2 = Paths.get("food");  // \cats\..\panther

        System.out.println(p.resolve(p2));
        System.out.println(p2.resolve(p));
    }

    static void c(){
        Path p = Paths.get("relative");
        Path p2 = Paths.get("E:\\absolute");

        System.out.println(p.resolve(p2));  // p2
        System.out.println(p2.resolve(p));  // E:\absolute\relative
    }

    static void c2(){
        Path p = Paths.get("a\\b\\c");
        Path p2 = Paths.get("");

        System.out.println(p.resolve(p2));  //test
        System.out.println(p2.resolve(p));  //test
    }

    static void c3(){
        Path p = Paths.get("a\\b\\c");
        Path p2 = Paths.get("d\\e\\f");

        System.out.println(p.resolve(p2));  //a\b\c\d\e\f
        System.out.println(p2.resolve(p));  //d\e\f\a\b\c
    }

    static void c4(){
        System.out.println(Absolute_Windows_Path.resolve(Absolute_Linux_Path));  // absolute linux file
        System.out.println(Absolute_Linux_Path.resolve(Absolute_Windows_Path));  //w file
    }

    public static void main(String[] args) {
//        m();
//        c();
//        c2();
//        c3();
        c4();
    }
}
