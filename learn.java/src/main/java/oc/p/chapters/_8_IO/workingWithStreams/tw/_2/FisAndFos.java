package oc.p.chapters._8_IO.workingWithStreams.tw._2;

import utils.resources.files.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

class FisAndFos {
    File file = Resources.pathToFile(this).toFile();

    public static void main(String[] args) {
        FisAndFos o = new FisAndFos();

        o.writeInteger();
        o.readInteger();

//        Resources.clean();
    }

    void writeInteger() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            getIntStream()
                    .forEach(i -> {
                        try {
                            fos.write(i);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IntStream getIntStream() {
        return IntStream.rangeClosed(300, 310);
    }

    void readInteger() {
        try (FileInputStream fis = new FileInputStream(file)) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
