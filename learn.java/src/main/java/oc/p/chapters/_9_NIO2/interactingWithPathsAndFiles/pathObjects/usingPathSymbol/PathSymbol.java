package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.usingPathSymbol;

import utils.print.Print;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class PathSymbol {

    static List <Path> paths = Arrays.asList(Paths.get(""), Paths.get("."), Paths.get(".."));

    static void m() {
        paths.forEach(p -> {
            System.out.println(p);
            System.out.println(p.toAbsolutePath());
            try {
                System.out.println(p.toRealPath());
            } catch (IOException e) {
                System.out.println("err");
            }
            Print.Delimitators.newLine();
        });
    }

    public static void main(String[] args) {
        m();
    }
}
