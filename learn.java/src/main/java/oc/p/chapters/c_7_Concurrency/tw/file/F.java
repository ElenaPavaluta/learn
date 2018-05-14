package oc.p.chapters.c_7_Concurrency.tw.file;

import utils.resources.files.Resources;
import java.io.File;

class F {
    String pkg = this.getClass().getPackage().getName();
    String path = Resources.Files.path(pkg);

    void dir(){
        File f = Resources.Files.directory(path +"\\p\\p2\\p3\\p4");
        System.out.println(f.isDirectory());  //true
        System.out.println(f.isFile());  //false
        Resources.Files.recursiveDelete(f);
    }

    public static void main(String[] args) {
        F f = new F();
        f.dir();
    }
}
