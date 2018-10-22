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
        FileSystem fileSystem = FileSystems.getDefault();

        Path path = fileSystem.getPath("c:", "a");
        System.out.println(path);
        System.out.println(path.isAbsolute());  //true

        path = fileSystem.getPath("/a/b");
        System.out.println(path);
        System.out.println(path.isAbsolute());  //false (true on Linux)

        path = fileSystem.getPath("\\a", "\\b", "\\c");
        System.out.println(path);
        System.out.println(path.isAbsolute());  //false

        fileSystem = FileSystems.getFileSystem(new URI("www.google.com"));
    }

    public static void main(String[] args) throws URISyntaxException {
        m();
    }
}
