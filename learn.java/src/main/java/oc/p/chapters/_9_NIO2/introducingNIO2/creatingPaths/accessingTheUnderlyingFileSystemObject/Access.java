package oc.p.chapters._9_NIO2.introducingNIO2.creatingPaths.accessingTheUnderlyingFileSystemObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Paths.get(): java.nio.directory.FileSystems.getPath()
 */
class Access {
    Path p = Paths.get("a");

    static void m() throws URISyntaxException {
        Path p = FileSystems.getDefault().getPath("a/b/c");
        System.out.println(p);

        Path p2 = FileSystems.getDefault().getPath("c:", "a", "b/c", "d");
        System.out.println(p2);

        Path p3 = FileSystems.getDefault().getPath("\\a\\b\\c");
        System.out.println(p3);

        FileSystem  fs = FileSystems.getFileSystem(new URI("www.selikoff.net"));
    }

    public static void main(String[] args) throws URISyntaxException {
        m();
    }
}
