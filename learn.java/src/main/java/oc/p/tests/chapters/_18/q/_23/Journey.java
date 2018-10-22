package oc.p.tests.chapters._18.q._23;

import utils.resources.files.Resources;

import java.io.File;

class Journey {


    static void m(){
        File  f = new File("/earth");
        System.out.println(f.getParent());
        System.out.println(f.getParentFile().getParent());
        System.out.println(f.getParentFile().getParentFile().getParent());
    }

    public static void main(String[] args) {
        m();
    }
}
