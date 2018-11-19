package utils.resources.files.tw;

import utils.resources.files.Resources;
import java.nio.file.Path;

class B {

    static final Package PKG = new B().getClass().getPackage();

    static void m() {
        Path p = Resources.Path.file(PKG, "b.txt");
        Resources.deleteFromSrcMainResources(p);
    }

    static void m2() {
        Path p = Resources.Path.directory(PKG, "a", "b", "c", "d");
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toString());
        Resources.deleteFromSrcMainResources(p);
    }

    static void m3() {
        Path p = Resources.Path.file(PKG, "a", "b", "c", "d", "e", "file.txt");
        System.out.println(p.getFileName());
        System.out.println(p.getNameCount());
        Resources.deleteFromSrcMainResources(p);
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
