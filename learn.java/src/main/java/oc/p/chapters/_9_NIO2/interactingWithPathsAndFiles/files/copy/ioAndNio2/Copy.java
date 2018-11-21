package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.copy.ioAndNio2;

import utils.resources.files.Resources;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.IntStream;

/**
 * static long	copy(InputStream in, Path target, CopyOption... options)
 * Copies all bytes from an input stream to a file.
 *
 * static long	copy(Path source, OutputStream out)
 * Copies all bytes from a file to an output stream.
 */
class Copy {
    static Package pkg = new Copy().getClass().getPackage();
    static File in = Resources.File.file(pkg, "in.txt");
    static File out = Resources.File.file(pkg, "out.txt");
    static Path path = Paths.get(Resources.srcMainResourcesPath(pkg), "path");

    static {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(in))) {
            IntStream.range(1, 6).forEach(i -> {
                try {
                    bw.write("Line: " + i);
                    bw.newLine();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void copy(){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(in))){
            Files.copy(bis, path, StandardCopyOption.REPLACE_EXISTING);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void paste(){
        try(OutputStream os = new FileOutputStream(out)){
            Files.copy(path, os);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    static void outStream(){
        try (OutputStream os = System.out){
            Files.copy(path, os);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy();
        paste();
        outStream();

        Resources.clean();
    }
}
