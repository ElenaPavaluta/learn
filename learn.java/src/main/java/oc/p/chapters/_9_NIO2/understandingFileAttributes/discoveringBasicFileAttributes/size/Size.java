package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.size;

import oc.p.chapters._9_NIO2.util.TestPath;
import utils.resources.files.Resources;
import utils.resources.files.create.populate.CreatePopulate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * static long	size(Path path)
 * Returns the size of a file (in bytes).
 *
 * The Files.size() method on dir is undefined and system dependent
 *
 * The size returned by this method represents the conceptual size of the data,
 * and this may differ from the actual size on the persistence storage device
 * due to file system compression and organization.
 *
 * The size() method throws the checked IOException if the file does not exist
 * or if the process is unable to read the file information.
 */
class Size {
    static final Package PACKAGE = new Size().getClass().getPackage();
    static java.nio.file.Path path = CreatePopulate.NIO.File.Path.file(PACKAGE);


    static void m() throws IOException {
        System.out.println(Files.size(path));
        Resources.clean();
    }

    static void m2() {
        try {
            System.out.println(Files.size(TestPath.Relative_Windows_Path));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The Files.size() method is defined only on files. Calling Files.size()
     * on a directory is system dependent and undefined. If you need to
     * determine the size of a directory and its contents,
     * you’ll need to walk the directory tree,
     */
    static void m3() {
        path = Paths.get(Resources.srcMainResourcesPackagePath(PACKAGE));
        try {
            path = Files.createDirectories(path);
            System.out.println(Files.size(path));
        } catch(IOException e) {
            e.printStackTrace();
        }
        Resources.clean();
    }

    public static void main(String[] args) throws IOException {
        m();
//        m2();
        m3();
    }
}
