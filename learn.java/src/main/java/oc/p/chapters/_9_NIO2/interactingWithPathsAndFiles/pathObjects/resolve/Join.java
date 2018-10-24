package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.resolve;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	resolve(Path other)
 *
 * Path resolve(String other)
 *
 * If the other parameter is an isAbsolute() absolute path then  returns other.
 *
 * If other is an empty path then returns this path.
 *
 * Otherwise this method considers this path to be a directory and resolves
 * the given path against this path.
 *
 * In the simplest case, the given path does not have a getRoot component, in which case this method
 * joins the given path to this path and returns a resulting path
 *
 * Where the given path has a root component then resolution is highly implementation dependent
 * and therefore unspecified.
 */
class Join {

    static void m() {
        Path p = Paths.get("/cats/../panther");
        Path p2 = Paths.get("food");

        System.out.println(p.isAbsolute());  //false
        System.out.println(p2.isAbsolute());  //false

        System.out.println(p.getRoot());  // /
        System.out.println(p2.getRoot());  // null

        System.out.println(p.resolve(p2));  // \cats\..\panther\food
        System.out.println(p2.resolve(p));  // \cats\..\panther
    }

    static void m2() {
        Path p = Paths.get("relative");
        Path p2 = Paths.get("E:\\absolute");

        System.out.println(p.isAbsolute());  //false
        System.out.println(p2.isAbsolute());  //true

        System.out.println(p.getRoot());  //null
        System.out.println(p2.getRoot());  //E:\

        System.out.println(p.resolve(p2));  //p2
        System.out.println(p2.resolve(p));  //E:\absolute\relative
    }

    static void m3() {
        Path p = Paths.get("a\\b\\c");
        Path p2 = Paths.get("");

        System.out.println(p.isAbsolute());  //false;
        System.out.println(p2.isAbsolute());  //false

        System.out.println(p.getRoot());  //null
        System.out.println(p2.getRoot());  //null

        System.out.println(p.resolve(p2));  //p
        System.out.println(p2.resolve(p));  //p
    }

    static void m4() {
        Path p = Paths.get("a\\b\\c");
        Path p2 = Paths.get("d\\e\\f");

        System.out.println(p.isAbsolute());  //false
        System.out.println(p2.isAbsolute());  //false

        System.out.println(p.getRoot());  //null
        System.out.println(p2.getRoot());  //null

        System.out.println(p.resolve(p2));  //a\b\c\d\e\f
        System.out.println(p2.resolve(p));  //d\e\f\a\b\c
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
