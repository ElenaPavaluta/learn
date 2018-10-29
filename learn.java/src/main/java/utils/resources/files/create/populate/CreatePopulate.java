package utils.resources.files.create.populate;

import utils.resources.files.Resources;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;

public interface CreatePopulate {

    int NR_OF_LINES = 007;

    static String content() {
        return IntStream.rangeClosed(1, NR_OF_LINES)
                        .mapToObj(i -> "Line nr " + i + "\n")
                        .collect(StringBuilder::new,
                                 StringBuilder::append,
                                 StringBuilder::append).toString();
    }

    interface IO{
        interface File {

            String IO_FILE = "io.file";

            static java.io.File file(Object object) {
                return file(object.getClass().getPackage());
            }

            static java.io.File file(Package destination, String fileName) {
                java.io.File file = Resources.File.file(destination, fileName);
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(content());
                } catch(IOException e) {
                    e.printStackTrace();
                }
                return file;
            }

            static java.io.File file(Package destination) {
                return file(destination, IO_FILE);
            }

        }
    }

    interface NIO {
        interface File {
            interface Path {

                static java.nio.file.Path file(Object obj, String... dest) {
                    return file(obj.getClass().getPackage(), dest);
                }

                static java.nio.file.Path file(Package pkg, String... dest) {
                    java.nio.file.Path path = Resources.Path.file(pkg, dest);
                    try (BufferedWriter bw = Files.newBufferedWriter(path)){
                        bw.write(content());

                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    return path;
                }
            }
        }
    }

}
