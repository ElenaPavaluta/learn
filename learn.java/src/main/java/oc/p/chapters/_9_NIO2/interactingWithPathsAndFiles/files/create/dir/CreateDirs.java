package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.dir;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static Path	createDirectory(Path dir, FileAttribute<?>... attrs)
 * Creates a new directory.
 *
 * static Path	createDirectories(Path dir, FileAttribute<?>... attrs)
 * Creates a directory by creating all nonexistent parent directories first.
 */
class CreateDirs {
    static String location = Resources.srcMainResourcesPath(new CreateDirs());

    static Path p = Paths.get(location, "p", "p2");
    static File f = new File(location + File.separator + "f/f2");

    static {
        System.out.println(p);
        System.out.println(f);
        Delimitators.equal();
    }

    static void createDirectories() {
        System.out.println(f.mkdirs());  //true
        try {
            p = Files.createDirectories(p);
        } catch (IOException e) {
            System.out.println("err");
        }
    }

    static void createExistingDirectories() {
        System.out.println(f.mkdirs());  //false
        try {
            p = Files.createDirectories(p);
        } catch (IOException e) {
            System.out.println("err: already exists");
        }
        Delimitators.equal();
    }


    public static void main(String[] args) {
        createDirectories();
        createExistingDirectories();
        Resources.clean();
    }
}


