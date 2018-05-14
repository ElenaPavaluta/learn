package oc.p.chapters.c_8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject;

import utils.resources.files.Resources;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class F {

    List<File> files = new ArrayList<>();
    String path = Resources.Files.path(this.getClass().getPackage().getName());

    public static final String NEW_PATH = "a\\b\\c\\d\\e\\f\\g";

    {
        File f = new File(Resources.SRC_MAIN_RESOURCES, path + NEW_PATH);

        /**
         *Because there are multiple files, doesn't do nothing
         */
//        f.mkdir();
        f.mkdirs();
        files.add(f);
    }

    void del(){
        files.forEach(Resources.Files::recursiveDelete);
    }

    public static void main(String[] args) {
        F f = new F();

        f.del();
    }
}
