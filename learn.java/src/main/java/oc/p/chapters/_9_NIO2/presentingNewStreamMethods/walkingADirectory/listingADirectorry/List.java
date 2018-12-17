package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory.listingADirectorry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.resources.files.Resources.SRC_MAIN_JAVA;
import static utils.resources.files.Separation.SLASH;

/**
 * static Stream<Path>	list(Path dir) Return a lazily populated Stream,
 * the elements of which are the entries in the directory.
 */
class List {

    Path path = Paths.get(SLASH.separationOf(SRC_MAIN_JAVA));

    public static void main(String[] args) throws IOException {
        List l = new List();
        l.m();
    }

    void m() throws IOException {
        Files.list(path)
                .max((p, p2) -> {
                    try {
                        return Long.compare(Files.getLastModifiedTime(p).toMillis(), Files.getLastModifiedTime(p2)
                                .toMillis());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return -1;
                }).ifPresent(p -> System.out.println(p.getFileName()));
    }
}
