package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.subpath;

import utils.print.Print;

import java.util.stream.IntStream;

import static oc.p.chapters._9_NIO2.util.TestPath.pathList;

/**
 * Path subpath(int beginIndex, int endIndex)  // endIndex: not included
 *
 * Returns a relative Path that is a subsequence of the name elements of this file
 */
class Create {
    static void m() {
        pathList.forEach(p->{
            int n = p.getNameCount();
            System.out.println(p);
            IntStream.rangeClosed(1, n)
                    .forEach(i-> System.out.println(p.subpath(0, i)));
            Print.Delimitators.equal();
        });
    }

    public static void main(String[] args) {
        m();
    }

}
