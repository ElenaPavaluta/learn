package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.relativize.tw;

import java.nio.file.Path;
import java.nio.file.Paths;

class R {

    static void m(){
        Path p = Paths.get("root/m/n/o.txt");
        Path p2 = Paths.get("root/m2");
        System.out.println(p);
        System.out.println(p2);

        System.out.println(p.relativize(p2));  // ..\..\..\m2
        System.out.println(p2.relativize(p));  // ..\m\n\o.txt
    }

    static void m2(){
        Path p = Paths.get("a/b/c");
        Path p2 = Paths.get("d/e/f");

        System.out.println(p);
        System.out.println(p2);
        System.out.println();

        System.out.println(p.relativize(p2));  //  ..\..|..\d\e\f
        System.out.println(p2.relativize(p));  //  ..\..\..\a\b\c
    }

    static void m3(){
        Path p = Paths.get("E:", "a", "b", "c");
        Path p2 = Paths.get("E:", "d", "e", "f");

        System.out.println(p);
        System.out.println(p2);
        System.out.println();

        System.out.println(p.relativize(p2));  // ..\..\..\d\e\f
        System.out.println(p2.relativize(p));  //  ..\..\..\a\b\c
    }

    static void m4(){
        Path p =Paths.get("E:", "a", "b");
        Path p2 = Paths.get("D:", "a", "b");
        System.out.println(p);
        System.out.println(p2);
        System.out.println();

        /**
         * RE: IllegalArgumentException
         */
        System.out.println(p.relativize(p2));
        System.out.println(p2.relativize(p));
    }

    static void m5(){
        Path p = Paths.get("E:", "a.txt");
        Path p2 = Paths.get("E:", "a", "b");

        System.out.println(p.relativize(p2));  // ..\a\b
        System.out.println(p2.relativize(p));  // ..\..\a.txt
    }

    static void m6(){
        Path p = Paths.get("root/a.txt");
        Path p2 =Paths.get("root/a.java");

        System.out.println(p.relativize(p2));  // ..\a.java
        System.out.println(p2.relativize(p));  // ..\a.txt
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
//        m4();
//        m5();
        m6();
    }
}
