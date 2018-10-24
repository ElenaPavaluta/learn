package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.resolve.tw;

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

    static void m(){
        Path p = Paths.get("\\a/b");
        Path p2 = Paths.get("c:\\d\\e");

        System.out.println(p);
        System.out.println(p2);

        System.out.println(p.isAbsolute());  //false
        System.out.println(p2.isAbsolute());  //true

        System.out.println(p.getRoot());  // \
        System.out.println(p2.getRoot());  //c:\

        System.out.println(p.resolve(p2));  //p2
        System.out.println(p2.resolve(p));  //c:\a\b
    }

    static void rule1(){
        Path p = Paths.get("c:\\a");
        Path p2 = Paths.get("c:\\b");

        System.out.println(p.resolve(p2));  //p2
        System.out.println(p2.resolve(p));  //p
    }

    static void rule2(){
        Path p = Paths.get("a/b");
        Path p2 = Paths.get("");

        System.out.println(p.resolve(p2));  //p
        System.out.println(p2.resolve(p));  //p
    }

    static void rule3(){
        Path p = Paths.get("/a/b");
        Path p2 = Paths.get("/c/d");

        System.out.println(p.resolve(p2));  // /a/b/c/d
        System.out.println(p2.resolve(p));  // /c/d/a/b
    }

    public static void main(String[] args) {
//        m();
//        rule1();
//        rule2();
        rule3();
    }
}
