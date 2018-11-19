package oc.p.tests.chapters._19.q._9.tw;

import utils.print.Print;
import utils.resources.files.PathRoot;
import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class RelativeAndAbsolute {

    static Path path;

    static void m() throws IOException {
        path = Paths.get("/root/a");
        path = Files.createDirectories(path);

        System.out.println(path);
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getName(0));

        Print.Delimitators.equal();
//
//        IntStream.rangeClosed(1, path.getNameCount())
//                .mapToObj(i->path.subpath(0, i))
//                .peek(p-> System.out.println(Files.exists(p)))
//                .forEach(System.out::println);
//
//        Delimitators.equal();
        Resources.delete(PathRoot.C, path);
    }

    static void m2() throws IOException {
        Path path = Paths.get("/");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toRealPath());
    }

    public static void main(String[] args) throws IOException {
        m();
//        m2();
    }


}
