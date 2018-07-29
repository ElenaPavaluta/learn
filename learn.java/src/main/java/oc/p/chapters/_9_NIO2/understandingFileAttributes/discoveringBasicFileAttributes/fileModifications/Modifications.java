package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileModifications;

import oc.p.chapters._9_NIO2.util.TestPath;
import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

/**
 * static FileTime	getLastModifiedTime(Path path, LinkOption... options)
 * Returns a file's last modified time.
 *
 * static Path	setLastModifiedTime(Path path, FileTime time)
 * Updates a file's last modified time attribute.
 */
class Modifications {

    static Package pkg = new Modifications().getClass().getPackage();
    static java.nio.file.Path path = CreatePopulate.NIO.File.Path.file(pkg);

    static void m() throws IOException {
        test(path);


        FileTime fileTime = FileTime.from(ZonedDateTime.now().toInstant());
        path = Files.setLastModifiedTime(path, fileTime);
        test(path);

        fileTime = FileTime.fromMillis(ZonedDateTime.now().toInstant().toEpochMilli());
        path = Files.setLastModifiedTime(path, fileTime);
        test(path);
            }

    private static void test(java.nio.file.Path path) throws IOException {
        FileTime fileTime = Files.getLastModifiedTime(path);
        System.out.println(fileTime.toMillis());
        Delimitators.newLine();
        System.out.println(fileTime);
        System.out.println(fileTime.toInstant());
        System.out.println(fileTime.to(TimeUnit.SECONDS));
        Delimitators.equal();
    }

    static void m2(){
        java.nio.file.Path p = TestPath.Absolute_Windows_Path;  //file does not exists
        try {
            test(p);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        m();
//        m2();

        Resources.recursiveDelete(path);
    }
}
