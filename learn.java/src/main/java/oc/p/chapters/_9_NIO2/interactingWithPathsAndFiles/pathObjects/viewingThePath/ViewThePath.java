package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.viewingThePath;


import utils.print.Print;

import java.util.stream.IntStream;

import static oc.p.chapters._9_NIO2.util.TestPath.pathList;

/**
 * String toString()
 *
 * int getNameCount()
 *
 * Path	getName(int index)
 *
 * Be aware that the
 * getName(int) method is zero-indexed
 * and drive letter not being taken into account
 *
 * getName(0) != getRoot()
 * getName(getNameCount() - 1) == getFileName();
 */
class ViewThePath {

    static void m() {
        pathList.forEach(p -> {
            System.out.println(p);
            System.out.println(p.getRoot());
            System.out.println(p.getNameCount());
            IntStream.range(0, p.getNameCount())
                    .forEach(i -> System.out.println(p.getName(i)));
            Print.Delimitators.newLine();
            System.out.println(p.getFileName());
            Print.Delimitators.equal();
        });
    }

    public static void main(String[] args) {
        m();
    }
}
