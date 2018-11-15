package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.tw;

import java.nio.file.Path;
import java.nio.file.Paths;

class Symbol {

    static void m(){
        Path p = Paths.get("");
        Path p2 = Paths.get(".");
        Path p3 = Paths.get("..");

        System.out.println(p.toAbsolutePath());
        System.out.println(p2.toAbsolutePath());
        System.out.println(p3.toAbsolutePath());

        System.out.println();

        System.out.println(p.toAbsolutePath().normalize());
        System.out.println(p2.toAbsolutePath().normalize());
        System.out.println(p3.toAbsolutePath().normalize());
    }

    public static void main(String[] args) {
        m();
    }
}
