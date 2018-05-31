package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.normalize;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	normalize()
 *
 * Returns a path that is this path with redundant name elements eliminated.
 */
class Normalize {

    static void m(){
        Path p = Paths.get("E:\\data");
        Path p2 = Paths.get("E:\\user\\home");

        Path p12, p21;
        System.out.println(p12 = p.relativize(p2));  //..\\user\\home
        System.out.println(p21 = p2.relativize(p));  // ..\\..\\data

        Path p112;
        System.out.println(p112 = p.resolve(p12));  //E:\\data\\..\\user\\home

        System.out.println(p112.normalize());
    }

    public static void main(String[] args) {
        m();
    }
}
