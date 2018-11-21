package oc.p.chapters._9_NIO2.understandingFileAttributes.improvingAccessWithViews.tw;

import utils.resources.files.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

class C {

    static Path path = Resources.Path.file(new C(), "fn");

    static void m() throws IOException {
        BasicFileAttributes bfa = Files.readAttributes(path, BasicFileAttributes.class);

        BasicFileAttributeView bfav = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        bfa = bfav.readAttributes();

        /**
         * This doesn't change anything
         */
        bfav.setTimes(null, null, null);


        Object o = bfa.fileKey();
        System.out.println(o);
    }

    public static void main(String[] args) throws IOException {
        m();

        Resources.clean();
    }
}
