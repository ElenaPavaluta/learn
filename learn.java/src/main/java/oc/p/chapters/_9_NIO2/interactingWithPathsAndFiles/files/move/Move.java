package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.move;

import utils.resources.files.Resources;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.IntStream;

/**
 * static Path	move(Path source, Path target, CopyOption... options)
 * Move or rename a file to a target file.
 */
class Move {


    static Package pkg = new Move().getClass().getPackage();
    static File f = Resources.IO.File.file(pkg, "f");
    static Path path = Paths.get(Resources.srcMainResourcesPath(pkg), "path");
    static Path path2 = Paths.get(Resources.srcMainResourcesPath(pkg),  "path2");

    static {
        try(Writer w = new FileWriter(f)) {
            IntStream.rangeClosed(1, 5).forEach(i -> {
                try {
                    w.write("Line: " + i);
                    w.write("\n");
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void copy() {
        try(InputStream is = new FileInputStream(f)) {
            Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void move(){
        try {
            Files.move(path, path2, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void read(){
        try(OutputStream os = System.out) {
        Files.copy(path2, os);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy();
        move();
        read();

        Resources.IO.File.recursiveDelete(f);
        Resources.NIO.Path.recursiveDelete(path, path2);
    }
}

