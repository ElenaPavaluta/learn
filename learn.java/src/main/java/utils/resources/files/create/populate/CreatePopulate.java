package utils.resources.files.create.populate;

import utils.resources.files.Resources;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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

    interface IO {

        String IO_FILE = "io.file";

        static File file(Object object){
            return file(object.getClass().getPackage());
        }

        static File file(Package destination) {
            File file = Resources.IO.File.file(destination, IO_FILE);
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(content());
            } catch(IOException e) {
                e.printStackTrace();
            }
            return file;
        }

    }

    interface NIO {

        String NIO_FILE = "nio.file";

        static Path file(Object obj, String... dest){
            return file(obj.getClass().getPackage(), dest);
        }

        static Path file(Package pkg, String... dest) {
            String mainResourcesPath = Resources.srcMainResourcesPath(pkg);
            Path path = Paths.get(mainResourcesPath, dest);
            try {
                path = Files.createDirectories(path);
                String[] newDest = Arrays.copyOf(dest, dest.length + 1);
                newDest[newDest.length - 1] = NIO_FILE;
                path = Paths.get(mainResourcesPath, newDest);
                path = Files.createFile(path);
                try(BufferedWriter bw = Files.newBufferedWriter(path)) {
                    bw.write(content());
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
            return path;
        }
    }
}
