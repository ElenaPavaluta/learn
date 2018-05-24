package oc.p.chapters.c_9_NIO2.introducingNIO2.creatingPaths.usingThePathsClass;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Use {

    static void m(){
        //path to a relative file
        Path p = Paths.get("pandas/cuddly.png");

        //path to an obsolute file in Windows based system
        Path p2 = Paths.get("c:\\zoo\\november\\e.txt");

        //path to an absolute file in Linux based system
        //starts with forward slash
        Path p3 = Paths.get("/home/zooDir");

        System.out.println(p);
        System.out.println(p2);
        System.out.println(p3);
    }

    static void m2(){
        Path p = Paths.get("a", "b", "c");
        Path p2 = Paths.get("c:", "zoo","november", "e.txt" );
        Path p3 = Paths.get("/", "home", "dir");

        System.out.println(p);
        System.out.println(p2);
        System.out.println(p3);
    }

    static void m3() throws URISyntaxException {
        /**
         * URI must reference absolute paths at runtime
         */
//        Path p = Paths.get(new URI("file://pandas.cudly.png"));  //RE

        Path p2 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        Path p3 = Paths.get(new URI("file:///home/zoodirectory"));

        System.out.println(p2);
        System.out.println(p3);
    }

    static void m4() throws URISyntaxException {
        Path p = Paths.get(new URI("http://www.wiley.com"));
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
