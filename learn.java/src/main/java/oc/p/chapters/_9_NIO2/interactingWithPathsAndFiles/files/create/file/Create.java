package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.file;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static String loc = Resources.srcMainResourcesPath(new Create());

    static List <Path> toDel = new ArrayList <>();


    static void createFile() {
        Path d = Paths.get(loc, "a/b");
        Path p = Paths.get(d.toString(), "p.txt");
        File f = new File(d.toString() + File.separator + "f.txt");
        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("not existent dir");
        }

        try {
            System.out.println(f.createNewFile());  //false
        } catch (IOException e) {
            System.out.println("not existent dir 2");
        }

        try {
            d = Files.createDirectories(d);
        } catch (IOException e) {
            System.out.println("err d");
        }

        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("err p");
        }

        try {
            System.out.println(f.createNewFile());  //true
        } catch (IOException e) {
            System.out.println("err f");
        }

        try {
            p = Files.createFile(p);
        } catch (IOException e) {
            System.out.println("p duplicate");
        }

        try {
            System.out.println(f.createNewFile());  //false
        } catch (IOException e) {
            System.out.println("f duplicate");
        }

        toDel.add(p);
        toDel.add(f.toPath());
        toDel.add(d);
        Delimitators.equal();
    }


    static void createLink() {
        Path dirLink = Paths.get(loc);
        try {
            dirLink = Files.createDirectories(dirLink);
        } catch (IOException e) {
            System.out.println("err dirLink");
        }

        Path dirExisting = Paths.get(loc, "c", "d");
        try {
            dirExisting = Files.createDirectories(dirExisting);
        } catch (IOException e) {
            System.out.println("err dirExisting");
        }

        Path existing = Paths.get(dirExisting.toString(), "existing");
        try {
            existing = Files.createFile(existing);
        } catch (IOException e) {
            System.out.println("p existing");
        }

        Path link = Paths.get(dirLink.toString(), "p");

        try {
            Files.createLink(link, existing);
        } catch (IOException e) {
            System.out.println("err create link");
        }

        toDel.addAll(Arrays.asList(link, dirLink, existing, dirExisting));
    }


    public static void main(String[] args) {
//        createFile();
        createLink();

        Resources.recursiveDelete(toDel.toArray(new Path[0]));
    }
}
