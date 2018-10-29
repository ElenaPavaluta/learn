package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.toRealPath;

import utils.print.Print;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static oc.p.chapters._9_NIO2.util.TestPath.pathList;

/**
 * Path	toRealPath(LinkOption... options)
 *
 * Returns the real path of an existing file.
 *
 * Remember:
 * Paths.get("") and Paths.get(".") point to the working dir
 */
class ToRealPath {

    static void m(List <Path> lst) {
        lst.forEach(p -> {
            System.out.println(p);
            System.out.println("exists: " + Files.exists(p));

            try {
                /**
                 * This method throws an exception due to the fact that the
                 * path might not reference a real file
                 */
                System.out.println("toRealPath: " + p.toRealPath());
            } catch (IOException e) {
                System.out.println("err");
            }

            System.out.println("toAbsolutePath: " + p.toAbsolutePath());
            Print.Delimitators.newLine();
        });
    }

    public static void main(String[] args) {
        List <Path> lst = new ArrayList <>();
        lst.add(Paths.get("."));
        lst.addAll(pathList);
        m(lst);
    }

}
