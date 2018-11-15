package oc.p.tests.chapters._19.q._6.tw;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class P {

    static List<Path> toDel = new ArrayList <>();

    static void m() throws IOException {
        Path p = Paths.get("q");
        p = Files.createDirectories(p);
        toDel.add(p);
        Delimitators.newLine();
    }

    static void m2() throws IOException {
        Path p0 = Paths.get("");
        Path p = Paths.get("lean.java/q2");
        p = Files.createDirectories(p);

        toDel.add(p);
        Delimitators.newLine();
    }

    static void m3() throws IOException {
        Path p = new File("/lean.java/m3").toPath();
        p = Files.createDirectories(p);
        toDel.add(p);
        Delimitators.newLine();
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
        m3();
        System.out.println(toDel.get(0));
        Files.deleteIfExists(toDel.get(0));
//        Resources.deletePathCreatedInTheLastHour(toDel.get(0));
    }
}
