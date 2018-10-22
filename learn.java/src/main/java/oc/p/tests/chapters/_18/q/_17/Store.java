package oc.p.tests.chapters._18.q._17;

import utils.resources.files.Resources;

import java.io.File;

class Store {

    static void m(){
        System.out.println(File.separator);
        System.out.println(System.getProperty("file.separator"));
        System.out.println(new File(new String()).separatorChar);
        System.out.println(System.getProperty("path.separator"));
    }

    public static void main(String[] args) {
        m();
    }
}
