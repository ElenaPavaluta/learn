package utils.resources.files.print;

import java.nio.file.attribute.BasicFileAttributes;

public interface Print {

    interface NIO{
        static void print(BasicFileAttributes bfa){
            System.out.println("isDirectory: " + bfa.isDirectory());
            System.out.println("isRegularFile: " + bfa.isRegularFile());
            System.out.println("isSymbolicLink: " +bfa.isSymbolicLink());
            System.out.println("isOther: " + bfa.isOther());
            System.out.println("fileKey: " +bfa.fileKey());
            System.out.println("size (in bytes): " +bfa.size());
            System.out.println("lastModifiedTime: " +bfa.lastModifiedTime());
            System.out.println("lastAccessTime: " +bfa.lastAccessTime());
            System.out.println("creationTime: " +bfa.creationTime());
        }
    }
}
