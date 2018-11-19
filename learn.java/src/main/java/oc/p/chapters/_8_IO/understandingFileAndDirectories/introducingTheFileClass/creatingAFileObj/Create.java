package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj;

import utils.resources.files.Resources;
import java.util.ArrayDeque;

class Create {

    final String pkg = this.getClass().getPackage().getName();
    final String path = Resources.path(pkg);
    ArrayDeque<java.io.File> files = new ArrayDeque<>();

    public static void main(String[] args) {
        Create c = new Create();
        c.dir();
        c.m();
        c.m2();

        c.del();
    }

    void dir() {
        java.io.File f = Resources.File.directory(path + "test\\p2\\p3\\p4");
        System.out.println(f.isDirectory());  //true
        System.out.println(f.isFile());  //false;
        files.push(f);
    }

    void m() {
        java.io.File a = new java.io.File("a.txt");
        a.mkdir();
        files.push(a);
    }

    void m2() {
        java.io.File f = new java.io.File(Resources.SRC_MAIN_RESOURCES, "b");
        f.mkdir();
        files.push(f);
    }

    void del() {
        for(java.io.File f : files) {
            Resources.cleanSrcMainResources();
        }
    }
}
