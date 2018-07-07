package oc.p.chapters._7_Concurrency.tw.file;

import utils.resources.files.Resources;

class F {
    String pkg = this.getClass().getPackage().getName();
    String path = Resources.path(pkg);

    void dir(){
        java.io.File f = Resources.IO.File.directory(path +"\\test\\p2\\p3\\p4");
        System.out.println(f.isDirectory());  //true
        System.out.println(f.isFile());  //false
        Resources.IO.File.recursiveDelete(f);
    }

    public static void main(String[] args) {
        F f = new F();
        f.dir();
    }
}
