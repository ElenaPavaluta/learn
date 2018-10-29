package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.file;

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
class CreateFile {

    static Path base = Resources.Path.directory(new CreateFile());
    static Path path;

    static void m() {
        path = Paths.get(base.toString(), "cf");
        try {
            path = Files.createFile(path);
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m2() {
        path = Paths.get(base.toString(), "cf");
        try {
            path = Files.createFile(path);
        } catch (IOException e) {
            System.out.println("err: already exists");
        }
    }

    public static void main(String[] args) {
        m();
        m2();

        Resources.recursiveDelete(path, base);
    }
}
