package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.tw;

import utils.print.Print;
import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

class MS2 {

    static String path = Resources.srcMainResourcesPath(new MS2().getClass().getPackage());
    static File dir;
    static File file;
    static File ne = new File("nonExistent");
    static File dest = new File(Resources.SRC_MAIN_RESOURCES);
    static List <File> lst /*= Arrays.asList(dir, file, ne)*/;  //NPE:

    static {
        dest.mkdirs();
        dir = new File(path + File.separator + "dir");
        dir.mkdirs();

        file = new File(dir, "file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lst = Arrays.asList(file, ne, dir, dest);
    }

    static void m() {
        m(File::getPath);
        m(File::exists);
        m(File::getName);
        m(File::getAbsolutePath);
        m(File::isDirectory);
        m(File::isFile);
        m(File::delete);
        m(File::getParent);
        m(File::length);
        m(File::lastModified);
//        m(File::renameTo);
//        m(File::listFiles);
    }

    static void m(Predicate <File> predicate) {
        lst.forEach(f -> System.out.println(predicate.test(f)));
        Print.Delimitators.equal();
    }

    static void m(ToLongFunction <File> function) {
        lst.forEach(f -> System.out.println(function.applyAsLong(f)));
        Print.Delimitators.equal();
    }

    static void m(Function <File, String> function) {
        lst.forEach(f -> System.out.println(function.apply(f)));
        Print.Delimitators.equal();
    }

    //Due to type erasure this overload isn't permitted
//    static void m(Function<File, File[]> function){
//    }


    public static void main(String[] args) {
        m();

        Resources.cleanSrcMainResources();
    }
}
