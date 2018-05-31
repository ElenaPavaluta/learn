package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.file;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path	createFile(Path path, FileAttribute<?>... attrs)
 * Creates a new and empty file, failing if the file already exists.
 *
 * static Path	createLink(Path link, Path existing)
 * Creates a new link (directory entry) for an existing file (optional operation).
 *
 * static Path	createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs)
 * Creates a symbolic link to a target (optional operation).
 */
class Create {

    static String loc = Resources.srcMainResourcesPath(new Create().getClass().getPackage());

    static {
        Path p = Paths.get(".");
        try {
            System.out.println(p.toRealPath());
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(loc);
        Delimitators.equal();
    }

    static void m() throws IOException {
        Path d = Paths.get(loc);
        d = Files.createDirectories(d);
        print(d);


        Path file = Paths.get(loc, "file.java");
        file = Files.createFile(file);  //CE if the file already exists
        print(file);

        Path d2 = Paths.get(loc, "a\\b\\c");
        d2 = Files.createDirectories(d2);
        print(d2);

        Path f2 = Paths.get(loc, "a\\b");
        f2 = Files.createLink(f2, file);
        print(f2);
    }

    private static void print(Path p) {
        System.out.println(p.getFileName());
        System.out.println(Files.isDirectory(p));
        System.out.println(Files.isRegularFile(p));
        System.out.println(Files.isSymbolicLink(p));
        Delimitators.equal();
        Delimitators.newLine();
    }

    public static void main(String[] args) throws IOException {
        m();
    }
}
