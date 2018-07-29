package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.files.readAndWrite.readAllLines;

import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * static List<String>	readAllLines(Path path)
 * Read all lines from a file.
 *
 * static List<String>	readAllLines(Path path, Charset cs)
 * Read all lines from a file.
 */
class ROL {
    static java.io.File f = CreatePopulate.IO.File.file(new ROL().getClass().getPackage());
    static Path path = f.toPath();

    static void m(){
        try {
            List<String> lst = Files.readAllLines(path);
            lst.forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
        Resources.recursiveDelete(path);
    }
}
