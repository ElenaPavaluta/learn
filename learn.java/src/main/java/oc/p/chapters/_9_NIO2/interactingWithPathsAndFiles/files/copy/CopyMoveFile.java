package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.copy;

import utils.resources.files.Resources;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * public static Path copy(Path source, Path targetCopy, CopyOption... options) throws IOException
 *
 * public static long copy(Path source, OutputStream out) throws IOException
 *
 * public static Path move(Path source, Path target, CopyOption... options) throws IOException
 */
class CopyMoveFile {
    static String loc = Resources.srcMainResourcesPackagePath(new CopyMoveFile().getClass().getPackage());

    static String SOURCE = "source";
    static String SOURCE_FILE = "source.txt";
    static String TARGET_COPY = "targetCopy";
    static String TARGET_MOVE = "targetMove";
    static String TARGET = "target.txt";
    static String A = "a";
    static String B = "b";
    static String C = "c";

    static Path sourceFile, targetCopyFile, targetMoveFile;

    static {
        Path source = Paths.get(loc, SOURCE);
        try {
            source = Files.createDirectories(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sourceFile = Paths.get(loc, SOURCE, SOURCE_FILE);
        try {
            sourceFile = Files.createFile(sourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = Files.newBufferedWriter(sourceFile)) {
            bw.write("Line 1\nLine 2\n  Line 3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path targetCopy = Paths.get(loc, TARGET_COPY, A, B, C);
        try {
            targetCopy = Files.createDirectories(targetCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }

        targetCopyFile = Paths.get(targetCopy.toString(), TARGET);

        Path targetMove = Paths.get(loc, TARGET_MOVE, A, B, C);
        try {
            targetMove = Files.createDirectories(targetMove);
        } catch (IOException e) {
            e.printStackTrace();
        }

        targetMoveFile = Paths.get(targetMove.toString(), TARGET);
    }

    static void copy() {
        try {
            Files.copy(sourceFile, targetCopyFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void move() {
        try {
            Files.move(sourceFile, targetMoveFile, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void moveBack() {
        sourceFile = Paths.get(loc, SOURCE, SOURCE_FILE);
        try {
            Files.move(targetMoveFile, sourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void copy2() {
        OutputStream os = System.out;
        try {
            Files.copy(sourceFile, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy();
        move();
        moveBack();
        copy2();
        Resources.clean();
    }


}
