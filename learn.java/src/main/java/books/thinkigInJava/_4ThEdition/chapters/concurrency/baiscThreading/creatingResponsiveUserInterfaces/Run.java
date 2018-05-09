package books.thinkigInJava._4ThEdition.chapters.concurrency.baiscThreading.creatingResponsiveUserInterfaces;

import java.io.IOException;

class Run {

    static void m() throws Exception {
        new UnResponsiveUI();
    }

    static void m2() throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(ResponsiveUI.d);
    }

    public static void main(String[] args) throws Exception {
//        m();  // must kill this process
        m2();
    }
}
