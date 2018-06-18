package oc.p.chapters._9_NIO2.presentingNewStreamMethods.walkingADirectory.printingFileContents;

import oc.a.chapters._3_core_java_apis.datesAndTimes.create.Create;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * static Stream<String>	lines(Path path)
 * Read all lines from a file as a Stream.
 *
 * static Stream<String>	lines(Path path, Charset cs)
 * Read all lines from a file as a Stream.
 */
class PrintingFileContents {

    Path path = CreatePopulate.NIO.file(this);

    void m(){
        try {
            Stream<String> stream = Files.lines(path);
            stream.forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintingFileContents pfc = new PrintingFileContents();

        pfc.m();
        Resources.recursiveDelete(pfc.path);
    }
}
