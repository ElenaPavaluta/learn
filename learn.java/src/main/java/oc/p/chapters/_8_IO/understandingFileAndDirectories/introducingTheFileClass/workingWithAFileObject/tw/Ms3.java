package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.tw;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;

class Ms3 {

    static  String path = Resources.srcMainResourcesPath(new Ms3());
    static File f;

    static void m() throws IOException {
        f = new File(path + File.separator + "ms3");
        f.createNewFile();

        System.out.println(f.toString());
        System.out.println(f.getPath());
        /**
         * Beware: toPath transforms a
         */
        System.out.println(f.toPath());
        System.out.println(f.getAbsolutePath());

        File f2 = new File(f.getPath());
        System.out.println(f.equals(f2));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("path: " +path);
        m();
    }
}
