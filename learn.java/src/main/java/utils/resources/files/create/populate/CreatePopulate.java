package utils.resources.files.create.populate;

import utils.resources.files.Resources;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public interface CreatePopulate {

    interface IO {
        static File file(Package destination, String content) {
            File file = Resources.IO.File.file(destination, "name");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(content);
            } catch(IOException e) {
                e.printStackTrace();
            }
            return file;
        }

        static File file(Package pkg, int nrOfLines) {
            String content = IntStream.rangeClosed(1, nrOfLines)
                                      .mapToObj(i -> "Line nr " + i + "\n")
                                      .collect(StringBuilder::new,
                                               StringBuilder::append,
                                               StringBuilder::append).toString();
            return file(pkg, content);
        }

        static File file(Package pkg) {
            return file(pkg, 007);
        }
    }
}
