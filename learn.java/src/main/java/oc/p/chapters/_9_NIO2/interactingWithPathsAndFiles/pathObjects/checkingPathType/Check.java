package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.checkingPathType;

import utils.print.Print;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static oc.p.chapters._9_NIO2.util.TestPath.*;

/**
 * boolean	isAbsolute()
 *
 * Path	toAbsolutePath()
 */
class Check {

    static Predicate<Path> isAbsolute = Path::isAbsolute;
    static UnaryOperator<Path> toAbsolutePath = Path::toAbsolutePath;

    static void m(){
        pathList.forEach(p->{
            System.out.println(p);
            System.out.println("isAbsolute: " + isAbsolute.test(p));
            System.out.println("toAbsolutePath: " + toAbsolutePath.apply(p));
            Print.Delimitators.newLine();
        });
    }

    public static void main(String[] args) {
       m();
    }
}
