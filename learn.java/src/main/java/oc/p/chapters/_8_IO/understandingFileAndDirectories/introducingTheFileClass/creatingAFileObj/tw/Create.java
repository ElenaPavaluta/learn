package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.creatingAFileObj.tw;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;

import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;

class Create {

    static String path  = Resources.srcMainResourcesPath(new Create().getClass().getPackage());
    static File f, f2, f3, f4;

    static void m() throws IOException {
        f = new File(path);
        System.out.println(f.mkdir());

        System.out.println(f.mkdirs());

        f2 = new File(path + File.separator + "f2.txt");
        System.out.println(f2.createNewFile());

        f3 = new File(SRC_MAIN_RESOURCES + File.separator + "f3.txt");
        System.out.println(f3.createNewFile());

        f4 = new File(SRC_MAIN_RESOURCES + File.separator + "dir");
        System.out.println(f4.mkdir());
    }


    public static void main(String[] args) throws IOException {
        System.out.println(path);
        m();
        Resources.cleanSrcMainResources();
    }
}
