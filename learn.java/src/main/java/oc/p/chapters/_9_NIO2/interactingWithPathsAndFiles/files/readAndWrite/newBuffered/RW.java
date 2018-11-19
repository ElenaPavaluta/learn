package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.readAndWrite.newBuffered;

import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Opens a file for reading, returning a BufferedReader to read text
 * from the file in an efficient manner.
 *
 * public static BufferedReader newBufferedReader(Path path) throws IOException
 * public static BufferedReader newBufferedReader(Path path, Charset cs) throws IOException
 *
 * Opens or creates a file for writing, returning a BufferedWriter to write text to the file in an efficient manner.
 *
 * public static BufferedWriter newBufferedWriter(Path path, OpenOption... options) throws IOException
 * public static BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options) throws IOException
 *
 */
class RW {
    static Package pkg = new RW().getClass().getPackage();
    static String loc = Resources.srcMainResourcesPath(pkg);

    /**
     * <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner);
     */
    static java.io.File file = CreatePopulate.IO.File.file(pkg);

    static Path read = file.toPath();
    static Path writeDir = Paths.get(loc, "\\a\\b\\c");
    static Path write = Paths.get(loc, "\\a\\b\\c", "write");

    static void read() {
        try (BufferedReader br = Files.newBufferedReader(read)) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void write() throws IOException {
        writeDir = Files.createDirectories(writeDir);
        write = Files.createFile(write);
        try (BufferedReader br = Files.newBufferedReader(read);
             BufferedWriter bw = Files.newBufferedWriter(write)) {
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        read();
        write();

        Resources.cleanSrcMainResources();
    }
}
