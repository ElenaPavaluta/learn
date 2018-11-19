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

class CreateLink {
    static Path dir = Resources.Path.directory(new CreateLink());
    static Path file = Resources.Path.file(new CreateLink(), "file");
    static  Path l = Resources.Path.directory(new CreateLink(), "a", "b", "c");
    static Path lToDir = Paths.get(l.toString(), "lToDir");
    static Path lToFile = Paths.get(l.toString(), "lToFile");

    static void m2() {
        try {
            lToDir = Files.createLink(lToDir, dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void m(){
        try {
            lToFile = Files.createLink(lToFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
//        m2();  //IOE
//        m();  //IOE: the file already exists
        Resources.cleanSrcMainResources();
    }

}
