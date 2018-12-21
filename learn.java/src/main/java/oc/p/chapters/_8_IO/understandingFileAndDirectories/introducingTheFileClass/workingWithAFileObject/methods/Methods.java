package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.methods;

import utils.resources.files.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static utils.resources.files.Resources.SRC_MAIN_RESOURCES;
import static utils.resources.files.Separation.SLASH;


class Methods {

    static List <File> lst = Arrays.asList(Test.dir, Test.file, Test.file2);


    static void m(Predicate <File> predicate) {
        lst.forEach(f -> System.out.println(predicate.test(f)));
    }

    static void m(Function <File, ?> function) {
        lst.forEach(f -> System.out.println(function.apply(f)));
    }


    public static void main(String[] args) {
//        m(File::exists);
//        m(File::getName);
//        m(File::getAbsolutePath);
//        m(File::isDirectory);
//        m(File::isFile);
//        m(File::length);
//        m(File::lastModified);
//        m(File::getParent);

//        m((Function <File, ?>) File::listFiles);
//        m((File f) -> f.listFiles());

        m2();


//        m(File::delete);
        
        Resources.clean();
    }

    private static void m2() {
        File file = Paths.get(SLASH.separationOf(SRC_MAIN_RESOURCES), SLASH.separationOf(new Methods().getClass().getPackage().getName()), "a", "b", "c").toFile();

//        System.out.println(file.mkdir());  //false
        System.out.println(file.mkdirs());

        lst.forEach(f -> System.out.println(f.renameTo(file)));
    }

}
