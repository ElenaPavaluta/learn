package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.normalize.tw;

import java.nio.file.Path;
import java.nio.file.Paths;

class N {

    static void m(){
        Path p = Paths.get("E:\\a\\b");
        Path p2 = Paths.get("E:\\c");

        System.out.println("relativize");
        System.out.println(p.relativize(p2));  // ..\..\c
        System.out.println(p2.relativize(p));  // ..\a\b
        System.out.println();

        System.out.println("rezolve");
        System.out.println(p.resolve(p2));  // E:\c
        System.out.println(p2.resolve(p));  //E:\a\b
        System.out.println();

        System.out.println("normalize");
        System.out.println(p.resolve(p.relativize(p2)));  //E:\a\b\..\..\c
        System.out.println(p.resolve(p.relativize(p2)).normalize());  //E:\c
        System.out.println();

        System.out.println(p2.resolve(p2.relativize(p))); //E:\c\..\a\b
        System.out.println(p2.resolve(p2.relativize(p)).normalize()); //E:\a\b

    }


    public static void main(String[] args) {
        m();
    }
}
