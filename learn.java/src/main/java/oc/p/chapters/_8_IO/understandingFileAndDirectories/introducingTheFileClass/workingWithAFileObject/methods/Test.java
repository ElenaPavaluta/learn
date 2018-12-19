package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.methods;

import utils.print.Print;
import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;

import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.SLASH;

class Test {

    static File dir = new File(SLASH.separationOf(SRC_MAIN_RESOURCES) + File.separator + SLASH.separationOf(new Test().getClass().getPackage().getName()));
    static File file = new File(dir.getPath(), "file");
    static File file2 = new File(SLASH.separationOf(Resources.SRC_MAIN_RESOURCES) + File.separator + "file");

    static {
        System.out.println("dir creation: " + dir.mkdirs());
        try {
            System.out.println("file creation: " + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Print.Delimitators.equal();
    }


    static void m() {
        System.out.println(dir);
        System.out.println(dir.getPath());
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.toPath());
    }

    public static void main(String[] args) {
        m();
        Resources.clean();
    }
}
