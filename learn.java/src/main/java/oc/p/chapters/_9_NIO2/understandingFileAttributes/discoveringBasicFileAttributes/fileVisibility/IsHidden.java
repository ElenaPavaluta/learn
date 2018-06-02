package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileVisibility;

import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * static boolean	isHidden(Path path)
 * Tells whether or not a file is considered hidden.
 *
 * Throws CE: NoSuchFileException if the file does not exists
 */
class IsHidden {

    static String loc = Resources.srcMainResourcesPath(new IsHidden());

    static void m() throws IOException {
        Path path = Paths.get(loc);
        path = Files.createDirectories(path);
        System.out.println(Files.isHidden(path));  //false
        Resources.recursiveDelete(path);

        path = Paths.get("a", "b");
        System.out.println(Files.isHidden(path));  //NoSuchFileException
    }

    public static void main(String[] args) throws IOException {
        m();
    }


}
