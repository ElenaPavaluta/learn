package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects.toRealPath;

import oc.p.chapters._9_NIO2.util.TestPath;
import utils.resources.files.Resources;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path	toRealPath(LinkOption... options)
 *
 * Returns the real path of an existing file.
 */
class ToRealPath {

    static {
        try {
            System.out.println(Paths.get(".").toRealPath());
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    static void m() throws IOException {
        Path p = TestPath.Relative_Linux_Path;
        System.out.println(p.toAbsolutePath());

        /**
         * Since the file does not exists throws an IOException
         */
        System.out.println(p.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }

    static void m2() throws IOException {
        java.io.File f = Resources.IO.File.file(new ToRealPath().getClass().getPackage(), "a.txt");
        System.out.println(f.exists());
        Path p = f.toPath();
        System.out.println(p);
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toRealPath(LinkOption.NOFOLLOW_LINKS));
        Resources.IO.File.recursiveDelete(f);
    }

    static void m3() throws IOException {
        java.io.File d = Resources.IO.File.directory(new ToRealPath().getClass().getPackage());
        System.out.println(d.exists());
        Path p = d.toPath();
        System.out.println(p);
        System.out.println(p.toAbsolutePath());
        System.out.println(p.toRealPath());
        Resources.IO.File.recursiveDelete(d);
    }

    public static void main(String[] args) throws IOException {
//        m();
//        m2();
        m3();
    }
}
