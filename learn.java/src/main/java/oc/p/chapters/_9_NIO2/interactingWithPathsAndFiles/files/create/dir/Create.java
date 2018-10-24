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
class Create {
    static String location = Resources.srcMainResourcesPath(new Create());

    static Path p = Paths.get(location, "p", "p2");
    static File f = new File(location + File.separator + "f/f2");

    static {
        System.out.println(p);
        System.out.println(f);
        Delimitators.newLine();
    }

    static void createDirectory() {
        System.out.println(f.mkdir());  //false
        try {
            p = Files.createDirectory(p);
        } catch (IOException e) {
            System.out.println("err");
        }

        System.out.println(f.exists());  //false
        System.out.println(Files.exists(p));  //false
    }

    static void createDirectories() {
        System.out.println(f.mkdirs());  //true
        try {
            p = Files.createDirectories(p);
        } catch (IOException e) {
            System.out.println("err");
        }

        System.out.println(f.exists());  //true
        System.out.println(Files.exists(p));  //true
    }

    static void alredyExists() {
        System.out.println(f.mkdirs());  //false
        try {
            p = Files.createDirectories(p);
        } catch (IOException e) {
            System.out.println("err");
        }
        System.out.println(f.exists());  //true
        System.out.println(Files.exists(p));  //true
    }

    public static void main(String[] args) {
        createDirectory();
        Delimitators.equal();
        createDirectories();
        Delimitators.equal();
        alredyExists();

        Resources.recursiveDelete(f, p);
    }
}


