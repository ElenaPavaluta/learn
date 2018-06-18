package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Stream<Path>	walk(Path start, FileVisitOption... options)
 * Return a Stream that is lazily populated with Path by walking the
 * file tree rooted at a given starting file.
 *
 * static Stream<Path>	walk(Path start, int maxDepth, FileVisitOption... options)
 * Return a Stream that is lazily populated with Path by walking the
 * file tree rooted at a given starting file.
 */
class Walk {

    void m(){
        Path path = Paths.get(Resources.SRC_MAIN_JAVA);
        try {
            long l = Files.walk(path).count();
            System.out.println(l);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void m2(){
        Path path = Paths.get(Resources.SRC_MAIN_JAVA);
        try {
            long l = Files.walk(path, 5).count();
            System.out.println(l);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Walk w = new Walk();
        w.m();
        w.m2();
    }
}
