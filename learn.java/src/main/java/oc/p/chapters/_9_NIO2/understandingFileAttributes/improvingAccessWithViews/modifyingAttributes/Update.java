package oc.p.chapters._9_NIO2.understandingFileAttributes.improvingAccessWithViews.modifyingAttributes;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import utils.resources.files.print.Print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * static <V extends FileAttributeView> V
 * getFileAttributeView(Path path, Class<V> type, LinkOption... options)
 *
 * Returns a file attribute view of a given type
 *
 * void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException;
 */
class Update {
    Path path = CreatePopulate.NIO.File.Path.file(this);

    public static void main(String[] args) throws IOException {
        Update u = new Update();
//        u.m();
//        u.m2();
        u.m3();

        Resources.recursiveDelete(u.path);
    }

    void m() throws IOException {
        FileAttributeView fav = Files.getFileAttributeView(path, FileAttributeView.class);

        BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        BasicFileAttributes bfa = bfav.readAttributes();
        Print.NIO.print(bfa);

        Delimitators.equal();

        FileTime fileTime = FileTime.from(Instant.now());
        bfav.setTimes(fileTime, fileTime, fileTime);

        Print.NIO.print(bfav.readAttributes());

        Delimitators.equal();
        System.out.println(bfav.name());
    }

    void m2() throws IOException {
        BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        /**
         * Setting these values to null just doesn't change the value
         */
        bfav.setTimes(null, null, null);

        Print.NIO.print(bfav.readAttributes());
    }

    void m3() throws IOException {
        Instant i = Instant.now();
        System.out.println(i);

        i = i.minus(LocalDate.now().getDayOfYear(), ChronoUnit.DAYS);
        System.out.println(i);

        BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        Print.NIO.print(bfav.readAttributes());
        Delimitators.equal();
        FileTime fileTime = FileTime.from(i);

        /**
         * It has no problem setting the FileTime in the past
         */
        bfav.setTimes(fileTime, fileTime, fileTime);

        Print.NIO.print(bfav.readAttributes());
    }
}
