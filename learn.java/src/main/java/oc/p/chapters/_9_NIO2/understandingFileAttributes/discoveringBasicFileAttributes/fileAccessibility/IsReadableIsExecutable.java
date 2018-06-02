package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileAccessibility;

import utils.delimitators.Delimitators;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean	isReadable(Path path)
 *
 * static boolean	isExecutable(Path path)
 *
 * isDirectory(),
 * isRegularFile(),
 * isSymbolicLink(),
 * isReadable()
 * isExecutable()
 * methods do not throw exceptions
 * if the file does not exist but instead return false.
 */
class IsReadableIsExecutable {
    static Path path = CreatePopulate.NIO.file(new IsReadableIsExecutable().getClass().getPackage());

    static void test(Path p){
        System.out.println(Files.isReadable(p));  //true
        /**
         * Returns true if the file is marked as executable within the
         * file system
         * Doesn't actually determine if the file is executable
         */
        System.out.println(Files.isExecutable(p));  //true
    }

    static void m(){
        test(path);
        Delimitators.equal();
        test(Paths.get("doesn't", "exists"));
    }

    public static void main(String[] args) {
        m();
        Resources.recursiveDelete(path);
    }
}
