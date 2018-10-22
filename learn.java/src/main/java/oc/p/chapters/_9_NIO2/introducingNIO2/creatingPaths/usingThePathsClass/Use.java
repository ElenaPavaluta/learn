package oc.p.chapters._9_NIO2.introducingNIO2.creatingPaths.usingThePathsClass;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Use {

    static void m() {
        //absolute path in Windows based system
        Path p = Paths.get("c:\\zoo\\november\\e.txt");
        print(p);

        //absolute path in Linux based system: starts with slash
        p = Paths.get("/home/zooDir");
        print(p);

        //relative path
        p = Paths.get("pandas/cuddly.png");
        print(p);
    }

    private static void print(Path p) {
        System.out.println(p);
        System.out.println(p.isAbsolute());
    }

    static void m2() {
        Path p = Paths.get("a", "b", "c");
        print(p);  //false

        p = Paths.get("c:", "zoo", "november", "e.txt");
        print(p);  //true

        p = Paths.get("/", "home", "dir");
        print(p);  //true: \\home\dir\
    }

    static void m3() throws URISyntaxException {
        /**
         * URI must reference absolute paths at runtime
         */
//        Path test = Paths.get(new URI("file://pandas.cudly.png"));  //RE

        Path p = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        System.out.println(p);

        p = Paths.get(new URI("file:///home/zoodirectory"));
        System.out.println(p);
    }

    static void m4() throws URISyntaxException {
        Path p = Paths.get(new URI("https://www.wiley.com"));
        System.out.println(p);
        URI u = p.toUri();
        System.out.println(u);


        Path p2 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
        System.out.println(p2);
        URI u2 = p2.toUri();
        System.out.println(u2);

    }

    public static void main(String[] args) throws URISyntaxException {
//        m();
//        m2();
//        m3();
        m4();
    }
}
