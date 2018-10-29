package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.dir;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class CreateDir {

    static Path base = Resources.Path.directory(new CreateDir().getClass().getPackage());

    static Path p = Paths.get(base.toString(), "p3");
    static File f = new File(base.toFile(), "f3");

    static void m() {
        System.out.println(f.mkdir());  //true
        try {
            p = Files.createDirectory(p);
        } catch (IOException e) {
            System.out.println("err");
        }
    }

    static void m2() {
        System.out.println(f.mkdir());  //false
        try {
            p = Files.createDirectory(p);
        } catch (IOException e) {
            System.out.println("err on creating: existing dir");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m();
        m2();
        Resources.recursiveDelete(f, p, base);
    }
}
