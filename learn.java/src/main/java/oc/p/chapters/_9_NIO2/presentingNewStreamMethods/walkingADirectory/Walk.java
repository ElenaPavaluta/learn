package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

/**
 * Return a Stream that is lazily populated with Path by walking the
 * file tree rooted at a given starting file.
 *
 * The file tree is traversed depth-first,
 * the elements in the stream are {@link Path} objects that are obtained as if by
 * {@link Path#resolve(Path) resolving} the relative path against {@code start}.
 *
 * static Stream<Path>	walk(Path start, FileVisitOption... options)
 * static Stream<Path>	walk(Path start, int maxDepth, FileVisitOption... options)
 */
class Walk {

    public static void main(String[] args) {
        Walk w = new Walk();
        w.m();
        w.m2();
    }

    void m() {
        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));
        try {
            long l = Files.walk(path).count();
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));
        try {
            long l = Files.walk(path, 5).count();
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
