package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileModifications;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.nio.file.attribute.FileTime.from;

/**
 * public static FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException
 *
 * public static Path setLastModifiedTime(Path path, FileTime time) throws IOException
 */
class Modifications {

    static Modifications m = new Modifications();

    static Path exist = Resources.Path.file(m, "a", "b", "c");
    static Path notExist = Paths.get("not exits");
    static List <Path> lst = Arrays.asList(exist, notExist);

    static void m() {
        lst.forEach(p -> {
            try {
                FileTime ft = Files.getLastModifiedTime(p);
                System.out.println(p.getFileName() + ": " + ft);
            } catch (IOException e) {
                System.out.println("Err: " + p);
                System.out.println("Can't getLastModifiedTime from a non existent file");
            }
        });
    }

    static void m2() {
        lst.forEach(p ->
        {
            try {
                Files.setLastModifiedTime(p, from(Instant.now()));
                System.out.println("Done for: " + p.getFileName());
            } catch (IOException e) {
                System.out.println("Err: " + p);
                System.out.println("Can't setLastModifiedTime for a non existent file");
            }
        });
    }

    static void m3() {
        try {
            Files.setLastModifiedTime(exist, FileTime.from(365, TimeUnit.DAYS));
            System.out.println("Can set a modification time in the past");
            Files.setLastModifiedTime(exist, FileTime.from(Integer.MAX_VALUE / 100, TimeUnit.DAYS));
            System.out.println("Can set a modification time in the future");
        } catch (IOException e) {
            System.out.println("Can't set a modification time in the past or in the future");
        }
        try {
            FileTime ft = Files.getLastModifiedTime(exist);
            System.out.println(ft);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m();
        m2();
        m3();
        Resources.clean();
    }
}
