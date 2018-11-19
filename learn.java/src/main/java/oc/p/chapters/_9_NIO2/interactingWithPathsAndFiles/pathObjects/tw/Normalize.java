package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.tw;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Normalize {

    static void m(){
        Path p = Paths.get("a/b/c/d/e/../../f/../e/j/../h" );
        System.out.println(p.toAbsolutePath().normalize());
    }

    static void m2(){
        Path p = Paths.get(".").toAbsolutePath().normalize();
        Path p2 = Paths.get("./.././../../").toAbsolutePath().normalize();

        System.out.println(p);
        System.out.println(p2);
    }

    static void m3() throws IOException {
        Path p = Resources.Path.directory(new Normalize());

        System.out.println(p);
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toRealPath());
        System.out.println(p.normalize());
    }

    public static void main(String[] args) throws IOException {
//        m();

//        m2();
        m3();

        Resources.cleanSrcMainResources();
    }
}
