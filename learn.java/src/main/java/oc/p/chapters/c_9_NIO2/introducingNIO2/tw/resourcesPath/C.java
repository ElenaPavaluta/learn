package oc.p.chapters.c_9_NIO2.introducingNIO2.tw.resourcesPath;

import utils.resources.files.Resources;

class C {
    Package p = this.getClass().getPackage();
    String relativePath = Resources.path(p);
    String srcRelativePath = Resources.srcMainResourcesPath(p);
    String abslutePath = Resources.absolutePath(p);

    {
        System.out.println(relativePath);
        System.out.println(srcRelativePath);
        System.out.println(abslutePath);
    }

    public static void main(String[] args) {
        C c =  new C();
    }
}
