package oc.p.chapters._9_NIO2.interactingWithPathsAndFiles.pathObjects.subpath;

import utils.delimitators.Delimitators;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static oc.p.chapters._9_NIO2.util.TestPath.*;

/**
 * Path subpath(int beginIndex, int endIndex)
 *
 * Returns a relative Path that is a subsequence
 * of the name elements of this file
 */
class Create {

    static List<Path> paths = Arrays.asList(Absolute_Linux_Path,
                                            Relative_Linux_Path,
                                            Absolute_Windows_Path,
                                            Relative_Windows_Path,
                                            Empty_Path);

    static void m() {
        paths.forEach(
                p ->
                {
                    System.out.println(p);
                    class A {
                        Path p;

                        public A(Path p) {
                            this.p = p;
                        }

                        void sub() {
                            int n = p.getNameCount();
                            Path pt = p;
                            while(n > 1) {
                                Path temp = pt.subpath(0, n - 1);
                                System.out.println(temp);
                                pt = temp;
                                n = pt.getNameCount();
                            }
                        }
                    }
                    new A(p).sub();
                    Delimitators.equal();
                    Delimitators.newLine();
                });
    }

    static void throwExcep(){
        Path p = Paths.get("ana", "are", "mere");
        System.out.println(p);

//        Path sp = p.subpath(1, 5);

//        Path sp2 = p.subpath(1,1);

        Path sp3 = p.subpath(-2, 1);
    }

    public static void main(String[] args) {
//        m();
        throwExcep();
    }
}
