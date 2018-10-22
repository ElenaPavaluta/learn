package utils.resources.files.tw;

import utils.resources.files.Resources;

import java.io.File;

class T {

    static void m(){
        Package aPackage = new T().getClass().getPackage();
        String s = Resources.absolutePath(aPackage);
        System.out.println(s);
        String s2 = Resources.srcMainResourcesPath(aPackage);
        File f = new File(s2);
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
    }

    public static void main(String[] args) {
        m();
    }
}
