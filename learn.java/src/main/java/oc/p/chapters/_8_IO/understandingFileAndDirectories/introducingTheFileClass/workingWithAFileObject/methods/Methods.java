package oc.p.chapters._8_IO.understandingFileAndDirectories.introducingTheFileClass.workingWithAFileObject.methods;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


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

//        m(File::listFiles);

        m((File f)->f.listFiles());
    }

}
