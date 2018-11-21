package oc.p.tests.chapters._19.q._9.tw;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class A {

    static void m() throws IOException {
        Path path = Paths.get(Resources.path(new A()));
        path = Files.createDirectories(path);
        System.out.println(path);
        Resources.deleteFrom(path);
    }

    static void m2() throws IOException {
        Path path = Paths.get(Resources.srcMainResourcesPath(new A()));
        path = Files.createDirectories(path);
        System.out.println(path);
    }

    public static void main(String[] args) throws IOException {
        m();
        m2();
    }
}
