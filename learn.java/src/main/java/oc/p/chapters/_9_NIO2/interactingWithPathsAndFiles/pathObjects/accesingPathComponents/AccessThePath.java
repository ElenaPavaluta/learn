package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.accesingPathComponents;

import utils.print.Print;

import java.nio.file.Path;
import java.util.function.UnaryOperator;

import static oc.p.chapters._9_NIO2.util.TestPath.pathList;

/**
 * Path	getFileName()
 * <p>
 * Path	getParent()
 * <p>
 * Path	getRoot()
 */
class AccessThePath {
    static void m(UnaryOperator <Path> op) {
        pathList.forEach(p -> System.out.println(op.apply(p)));
        Print.Delimitators.equal();
    }

    static void getFileName() {
        m(Path::getFileName);
    }

    static void getParent() {
        m(Path::getParent);
    }

    static void getRoot() {
        m(Path::getRoot);
    }

    public static void main(String[] args) {
        getFileName();
        getParent();
        getRoot();
    }
}
