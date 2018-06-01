package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.create.file;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    static String loc = Resources.srcMainResourcesPath(new Create().getClass().getPackage());

    static List<Path> toDel = new ArrayList<>();

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

        Path f2 = Paths.get(loc, "a\\b\\symb.java");
        f2 = Files.createLink(f2, file);
        print(f2);

        toDel.add(d);
        toDel.add(file);
        toDel.add(d2);
        toDel.add(f2);
    }

    static void m2() throws IOException {
        Path d = Paths.get(loc);
        d = Files.createDirectories(d);

        Path f = Paths.get(loc, "f.java");
        Files.deleteIfExists(f);
        f = Files.createFile(f);
        print(f);

        String s = "a\\b\\c";
        Path d2= Paths.get(loc, s);
        d2 = Files.createDirectories(d2);

        Path f2 = Paths.get(loc, s, "link");
        Files.deleteIfExists(f2);
        f2 = Files.createLink(f2, f);
        print(f2);

        String s2 = "d/e/f";
        Path d3 = Paths.get(loc, s, s2);
        d3 = Files.createDirectories(d3);

        Path f3 = Paths.get(loc, s, s2, "symb");
        Files.deleteIfExists(f3);
        f3 = Files.createSymbolicLink(f3, f);
        print(f3);

        toDel.add(d);
        toDel.add(f);
        toDel.add(d2);
        toDel.add(f2);
        toDel.add(d3);
        toDel.add(f3);
    }

    private static void print(Path p) {
        System.out.println(p.getFileName());
        System.out.println("directory:" + Files.isDirectory(p));
        System.out.println("file: " +Files.isRegularFile(p));
        System.out.println("symbolic lync: " +Files.isSymbolicLink(p));
        Delimitators.equal();
        Delimitators.newLine();
    }

    public static void main(String[] args) throws IOException {
//        m();
        m2();

        Resources.NIO2.Path.recursiveDelete(toDel.toArray(new Path[0]));
    }
}
