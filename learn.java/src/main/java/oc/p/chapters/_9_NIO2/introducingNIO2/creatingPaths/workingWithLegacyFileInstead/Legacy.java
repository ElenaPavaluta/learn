package oc.p.chapters._9_NIO2.introducingNIO2.creatingPaths.workingWithLegacyFileInstead;

import utils.resources.files.Resources;
import java.nio.file.Path;
import java.nio.file.Paths;

class Legacy {

    void m(){
        java.io.File file = Resources.IO.File.file(this.getClass().getPackage(), "cuddly.png");
        Path path = file.toPath();

        System.out.println(file);
        System.out.println(path);
        System.out.println();

        Path path2 = Paths.get("cuddle_2.png");
        java.io.File file2 = path2.toFile();
        System.out.println(path2);
        System.out.println(file2);
        Resources.IO.File.recursiveDelete(file, file2);
    }

    public static void main(String[] args) {
        Legacy l = new Legacy();
        l.m();

    }
}