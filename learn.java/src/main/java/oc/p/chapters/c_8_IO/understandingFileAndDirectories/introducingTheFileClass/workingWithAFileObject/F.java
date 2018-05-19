package oc.p.chapters.c_8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject;

import utils.resources.files.Resources;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class F {

    List<File> files = new ArrayList<>();
    String path = Resources.path(this.getClass().getPackage().getName());

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

    void m(){
        File f = files.get(0);

//        _m(f);
    }

    private void _m(File f) {
        System.out.println(f.exists());  //true
        System.out.println(f.getName());  //g;
        System.out.println(f.getAbsolutePath());  //
        System.out.println(f.isDirectory());  //true
        System.out.println(f.isFile());  //false
        System.out.println(f.length());
        System.out.println(f.lastModified());
        System.out.println(f.renameTo(new File(f.getPath(), "n\\n2\\n3")));
        System.out.println(f.getParent());
//        Arrays.asList(f.listFiles()).forEach(System.out::println);
        System.out.println(f.getPath());
    }

    void m2() throws IOException {
        File f = new File(files.get(0).getPath(), "q.txt");
        f.createNewFile();

        files.add(f);

        _m(f);

    }

    void f3() throws IOException {
        File f = new File("a");
        f.mkdir();
        /**
         * When run second time, since the new File
         * exits, doesn't do any renaming
         */
        f.renameTo(new File("b"));
        files.add(f);

        File f2 = new File("a2.txt");
        f2.createNewFile();
        f2.renameTo(new File("b2.txt"));
        files.add(f2);


    }

    void del(){
        files.forEach(Resources.Files::recursiveDelete);
    }

    public static void main(String[] args) throws IOException {
        F f = new F();

        f.m();
        f.m2();
//        f.f3();


        f.del();
    }
}
