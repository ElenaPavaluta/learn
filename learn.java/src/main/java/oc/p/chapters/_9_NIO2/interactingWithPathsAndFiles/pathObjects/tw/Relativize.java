package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.tw;

import utils.delimitators.Delimitators;

import java.nio.file.Path;
import java.nio.file.Paths;

class Relativize {

    static void m() {
        Path p = Paths.get("a/b/c/../../e");
        Path p2 = Paths.get("c/d/g");

        System.out.println(p.relativize(p2));  // ../../../../../../c/d/g
        System.out.println(p2.relativize(p));  // ../../../a/b/c/../../e

        Delimitators.newLine();

        System.out.println(p.normalize());  // a/e
        System.out.println(p.normalize().relativize(p));  // ../../b/c/../../e

        Delimitators.newLine();
        System.out.println(p.normalize().relativize(p2));  // ../../c/d/g
        System.out.println(p2.relativize(p.normalize()));  // ../../../a/e

        Delimitators.newLine();
    }

    static void m2() {
        Path p = Paths.get("r", "i/w/e/././../../t/y");
        Path p2 = Paths.get("r", "a/s/../../../../d/f/g");

        System.out.println(p.normalize());  // r/interview/t/y
        System.out.println(p2.normalize());  // ../d/f/g

        Delimitators.newLine();
        System.out.println(p.normalize().relativize(p));  // ../../w/e/././../../t/y
        System.out.println(p.relativize(p.normalize()));  // ../../../../../../../../t/y

        Delimitators.newLine();
        System.out.println(p.relativize(p2));  // ../../../../../../../../../a/s/../../../../d/f/g
        System.out.println(p2.relativize(p));  // ../../../../../../../../../interview/w/e/././../../t/y

        Delimitators.newLine();
        System.out.println(p.normalize().relativize(p2.normalize()));  // ../../../../../d/f/g
        System.out.println(p2.normalize().relativize(p.normalize()));  // ../../../../r/interview/t/y
    }

    static void m3() {
        /**
         * If it start with / or a drive letter is an absolute path
         */
        System.out.println(Paths.get("/", "a/b").isAbsolute());  //true
        System.out.println(Paths.get("\\", "a\\c").isAbsolute());  //true
    }

    static void m4() {
        Path p = Paths.get("/", "i/w/e/r/t/.././../y/u");
        Path p2 = Paths.get("/", "./.././../a/s/d/f/./../g");

        System.out.println(p.normalize());  // \\interview\interview\e\y\\u
        System.out.println(p2.normalize());  // \\.\..\a\s\d\g
    }

    public static void main(String[] args) {
//        m();
//        m2();
//        m3();
        m4();
    }
}
