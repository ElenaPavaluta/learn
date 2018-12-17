package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj;

import utils.resources.files.util.FileUtil;

import java.util.ArrayDeque;

import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.SLASH;

class Create {

    final String pkg = this.getClass().getPackage().getName();
    final String path = SLASH.separationOf(pkg);
    ArrayDeque <java.io.File> files = new ArrayDeque <>();

    public static void main(String[] args) {
        Create c = new Create();
        c.dir();
        c.m();
        c.m2();

//        Resources.clean();
    }

    void dir() {
        java.io.File f = FileUtil.directory(path + "test\\p2\\p3\\p4");
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
        java.io.File f = new java.io.File(SLASH.separationOf(SRC_MAIN_RESOURCES), "b");
        f.mkdir();
        files.push(f);
    }

}
