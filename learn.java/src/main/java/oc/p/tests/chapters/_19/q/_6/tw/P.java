package oc.p.tests.chapters._19.q._6.tw;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class P {

    static Path path = null;

    static void m() throws IOException {
        Path p0 = Paths.get("");

        path = Paths.get("lean.java", "m", "n");
        path = Files.createDirectories(path);
    }


    public static void main(String[] args) throws IOException {
        m();
//        Files.deleteIfExists(path);

        Resources.deleteRootBasedPathCreatedInTheLastHour(path);
    }
}
