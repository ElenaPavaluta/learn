package oc.p.chapters._9_NIO2.understandingFileAttributes.improvingAccessWithViews.readingAttributes;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * static <A extends BasicFileAttributes> A
 * readAttributes(Path path, Class<A> type, LinkOption... options)
 */
class Read {

   Package p  = this.getClass().getPackage();
   Path path = CreatePopulate.NIO.file(p);

   void m() throws IOException {
       BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);

       boolean b = bfa.isDirectory();
       boolean b2 = bfa.isRegularFile();
       boolean b3 = bfa.isSymbolicLink();

       /**
        * used to check for paths that are not
        * files, directories, or symbolic links,
        * such as paths that refer to resources or devices in some file systems
        */
       boolean b4 = bfa.isOther();

       /**
        * returns a file system value that represents
        * a unique identifier for the file within the file system or null
        * if it is not supported by the file system
        */
       Object  o = bfa.fileKey();

       long size = bfa.size();

       FileTime ft = bfa.creationTime();
       FileTime ft2 = bfa.lastModifiedTime();
       FileTime ft3 = bfa.lastAccessTime();

       System.out.println(b);
       System.out.println(b2);
       System.out.println(b3);
       System.out.println(b4);
       Delimitators.newLine();

       System.out.println(o);
       Delimitators.newLine();

       System.out.println(size);
       Delimitators.newLine();

       System.out.println(ft);
       System.out.println(ft2);
       System.out.println(ft3);

       Resources.recursiveDelete(path);
   }

    public static void main(String[] args) throws IOException {
        Read r  =new Read();
        r.m();
    }
}
