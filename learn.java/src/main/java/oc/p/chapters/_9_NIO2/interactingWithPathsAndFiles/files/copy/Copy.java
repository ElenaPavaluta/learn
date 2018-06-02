package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.copy;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class Copy {
    static String loc = Resources.srcMainResourcesPath(new Copy().getClass().getPackage());
    static List<Path> delLst = new ArrayList<>();

    static String SOURCE = "source";
    static String DEST = "dest";
    static String A = "a";
    static String B = "b";
    static String C = "c";

    static void m() throws IOException {
        Path p = Paths.get(loc, SOURCE, A, B, C);
        p = Files.createDirectories(p);

        Path destination = Paths.get(loc, DEST);
        destination = Files.createDirectories(destination);


        Path source = Paths.get(loc, SOURCE, A);

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);

        delLst.add(p);
        delLst.add(destination);
        delLst.add(source);
    }

    static void m2() throws IOException {
        Path p = Paths.get(SOURCE, "file.txt");
        p = Files.createFile(p);
    }

    public static void main(String[] args) throws IOException {
        m();
//        m2();
    }
}
