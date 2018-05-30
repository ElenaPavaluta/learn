package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.usingPathObjects
        .viewingThePath;


import oc.p.chapters._9_NIO2.util.TestPath;
import java.nio.file.Path;
import java.util.stream.IntStream;

/**
 * String	toString()
 *
 * int getNameCount()
 *
 * Path	getName(int index)
 *
 * Be aware that the
 * getName(int) method is zero-indexed,
 * with the file system root excluded from the Absolute_Linux_Path components.
 */
class ViewThePath {

    public static void main(String[] args) {
        ViewThePath viewThePath = new ViewThePath();
        viewThePath.m(TestPath.Absolute_Linux_Path);
        viewThePath.m2(TestPath.Absolute_Linux_Path);
        System.out.println();
        viewThePath.m(TestPath.Relative_Linux_Path);
        viewThePath.m2(TestPath.Relative_Linux_Path);
        System.out.println();
        viewThePath.m(TestPath.Absolute_Windows_Path);
        viewThePath.m2(TestPath.Absolute_Windows_Path);

    }

    void m(Path path) {
        System.out.println("The Absolute_Linux_Path name is: " + path);
    }

    void m2(Path path) {
        IntStream.range(0, path.getNameCount())
                 .forEach(i -> System.out.println("Element: " + i + " is: " + path.getName(i)));
    }
}
